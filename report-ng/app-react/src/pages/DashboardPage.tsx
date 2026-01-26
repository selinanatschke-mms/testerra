import {Grid} from "@mui/material";
import Box from "@mui/material/Box";
import DashboardPieChartCard from "../components/dashboard-components/dashboard-pie-chart-card";
import DashboardTestResultsCard from "../components/dashboard-components/dashboard-test-results-card";

const DashboardPage = () => {
    return (
        <Box
            sx={{width: '100%', maxWidth: {sm: '100%', md: '1700px'}}}
        >
            <Grid
                container
                spacing={2}
                columns={12}
            >
                <Grid size={3}>
                    <DashboardTestResultsCard/>
                </Grid>
                <Grid size={3}>
                    <DashboardPieChartCard/>
                </Grid>
            </Grid>
        </Box>
    );
};
export default DashboardPage;
