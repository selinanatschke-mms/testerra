import {useProtobuf} from "../provider/DataProvider.tsx";
import Box from "@mui/material/Box";
import {Typography} from "@mui/material";

const TestsPage = () => {

    const { protoData, isLoading, error } = useProtobuf();

    if (isLoading) return <div>Lade Konfiguration...</div>;
    if (error) return <div>Fehler: {error.message}</div>;
    if (!protoData) return null;

    return (
        <Box>
            <Typography variant="h6">Test view</Typography>
            <Typography>
                {protoData.executionContext?.runConfig?.reportName}
            </Typography>
        </Box>

    );
};
export default TestsPage;
