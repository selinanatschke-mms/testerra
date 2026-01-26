import {Typography, useTheme} from "@mui/material";
import React from "react";
import ReportCard from "../../widgets/report-card/report-card";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import CancelIcon from "@mui/icons-material/Cancel";
import ListItemText from "@mui/material/ListItemText";

const DashboardFailureAspectsCard: React.FC = () => {
    const theme = useTheme();

    return (
        <ReportCard label="Top 3 Failure Aspects" sx={{p: 0, ":last-child": {padding: 0}}}>
            <List>
                <ListItem disablePadding>
                    <ListItemButton sx={{pt: 0, pb: 0}}>
                        <ListItemIcon>
                            <CancelIcon sx={{color: theme.custom.statusColors.failed}}/>
                        </ListItemIcon>
                        <ListItemText primary="AssertionError: Failing for reasons"/>
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding>
                    <ListItemButton sx={{pt: 0, pb: 0}}>
                        <ListItemIcon>
                            <CancelIcon sx={{color: theme.custom.statusColors.skipped}}/>
                        </ListItemIcon>
                        {/* This ListItemText uses disabledTypography (to explicity forbid using the built in typography) to add a separate typography element as its child component
                            The advantage of this is, that we can use the provided noWrap property which automatically truncates the text.*/}
                        <ListItemText disableTypography={true}>
                            <Typography noWrap> Throwable: Method
                                eu.tsystems.mms.tic.testerra.plugins.teamcity.test.SimpleTest2.testT04_SkippedTest() on
                                instance eu.tsystems.mms.tic.testerra.plugins.teamcity.test.SimpleTest2@6134ac4a depends
                                on not successfully finished methods
                                [eu.tsystems.mms.tic.testerra.plugins.teamcity.test.SimpleTest2.testT03_SimpleFailedTest()
                                on instance
                                eu.tsystems.mms.tic.testerra.plugins.teamcity.test.SimpleTest2@6134ac4a]</Typography>
                        </ListItemText>
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding>
                    <ListItemButton sx={{pt: 0, pb: 0}}>
                        <ListItemIcon>
                            <CancelIcon sx={{color: theme.custom.statusColors.expected_failed}}/>
                        </ListItemIcon>
                        <ListItemText primary="AssertionError: Failing for reasons..."/>
                    </ListItemButton>
                </ListItem>
            </List>
        </ReportCard>
    );
};
export default DashboardFailureAspectsCard;
