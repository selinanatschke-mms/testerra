import {useEffect, useMemo, useState} from "react";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {useReportData} from "../provider/DataProvider";
import ReportChip from "../widgets/report-chip/report-chip";
import {StatusService} from "../model/status-service";
import ReadMoreIcon from '@mui/icons-material/ReadMore';
import CancelIcon from '@mui/icons-material/Cancel';
import {Stack, Typography} from "@mui/material";
import Link from '@mui/material/Link';
import type {FiltersState} from "../hooks/useTestListFilters";
import {MethodDetails} from "../model/MethodDetails";
import {ClassName, classNameConverter} from "../utils/classNameConverter";

interface TestListProps {
    filters: FiltersState
}

const TestList = ({filters}: TestListProps) => {
    const {executionMngr, isLoading, error} = useReportData();

    if (isLoading) return <div>Lade Konfiguration...</div>;
    if (error) return <div>Fehler: {error.message}</div>;
    if (!executionMngr) return null;

    const execStatistics = executionMngr.getExecutionStatistics();

    // useMemo to make sure methodDetails is only built new if the data basis (execStatistics) changes (this prevents that methodDetails is built new each frame and causes useEffect trigger)
    const methodDetails = useMemo(() => {
        return execStatistics.classStatistics.flatMap(classStatistic =>
            classStatistic.methodContexts
                .map(methodContext => (
                    methodContext.contextValues && methodContext.contextValues.id
                        ? executionMngr.getMethodDetails(methodContext.contextValues.id)
                        : undefined
                ))
        ).filter((detail): detail is MethodDetails => detail !== undefined);  // removes undefined values
    }, [execStatistics, executionMngr]);

    // useEffect to filter based on filter props (because we wait data changes from multiple other Ui components and want to react to them and synchronize filter state)
    const [filteredMethodDetails, setFilteredMethodDetails] = useState<MethodDetails[]>([]);    // new filter state for filtered data
    useEffect(() => {
        let filtered = methodDetails;

        // status filter
        if (filters.status && filters.status.length > 0) {
            filtered = filtered.filter(detail => {
                if (detail?.methodContext.resultStatus === undefined) return false;
                return filters.status?.includes(detail.methodContext.resultStatus);
            });
        }

        // class filter
        if (filters.class && filters.class.length > 0) {
            filtered = filtered.filter(detail => {
                return filters.class?.includes(classNameConverter(detail.classStatistics.classIdentifier, ClassName.simpleName))
            });
        }

        setFilteredMethodDetails(filtered);
    }, [methodDetails, filters]); // methodDetails and filters as dependencies => every time one of them changes, this will be executed again

    return (
        <TableContainer component={Paper}>
            <Table sx={{
                tableLayout: "fixed",
                width: "100%"
            }}
                   aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell style={{width: "15%"}}>Status</TableCell>
                        <TableCell align={"center"} style={{width: "10%"}}>Run index</TableCell>
                        <TableCell style={{width: "25%"}}>Class</TableCell>
                        <TableCell style={{width: "10%"}}>Start time</TableCell>
                        <TableCell>Method</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {filteredMethodDetails && filteredMethodDetails.length > 0 && filteredMethodDetails.map((filteredMethodDetail) => (
                        <TableRow key={filteredMethodDetail?.methodContext.methodRunIndex}
                                  sx={{'&:last-child td, &:last-child th': {border: 0}}}>
                            <TableCell component="th" scope="row">
                                <ReportChip key={filteredMethodDetail?.methodContext.resultStatus}
                                            label={StatusService.getLabel(filteredMethodDetail?.methodContext.resultStatus!)}
                                            sx={{
                                                background: StatusService.getColor(filteredMethodDetail?.methodContext.resultStatus!),
                                                color: "white"
                                            }}/>
                            </TableCell>
                            <TableCell align={"center"}>
                                {filteredMethodDetail?.methodContext.methodRunIndex}
                            </TableCell>
                            <TableCell sx={{overflowWrap: "anywhere"}}>
                                <Link href="#/Tests">{StatusService.separateNamespace(filteredMethodDetail?.classStatistics.classIdentifier ?? "").class}</Link>
                            </TableCell>
                            <TableCell>
                                {new Date(filteredMethodDetail?.methodContext.contextValues?.startTime ?? 0).toLocaleTimeString()}
                            </TableCell>
                            <TableCell sx={{overflowWrap: "anywhere"}}>
                                <Stack direction="column">
                                    <Stack direction="row" sx={{gap: 1, alignItems: "center"}}>
                                        <ReadMoreIcon/>
                                        <Link href="#/Tests">{filteredMethodDetail?.identifier}</Link>
                                    </Stack>
                                    {filteredMethodDetail?.failureAspects.map((failureAspect) => (
                                        <Typography variant="body2" sx={{mt: 1}}>
                                            {failureAspect.relevantCause?.className &&
                                                StatusService.separateNamespace(failureAspect.relevantCause?.className).class}:
                                            {failureAspect.message}
                                        </Typography>
                                    ))}
                                    {filteredMethodDetail?.failsAnnotation?.description &&
                                        <Stack direction="row" sx={{gap: 1, alignItems: "center", mt: 1}}>
                                            <CancelIcon
                                                sx={{color: StatusService.getColor(filteredMethodDetail?.methodContext.resultStatus!)}}/>
                                            <Typography
                                                variant="caption">{filteredMethodDetail.failsAnnotation.description}</Typography>
                                        </Stack>
                                    }
                                </Stack>

                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
};
export default TestList;
