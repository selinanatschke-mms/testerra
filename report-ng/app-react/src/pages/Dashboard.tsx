import {Card, CardContent, Divider, Grid, Typography, useTheme} from "@mui/material";
import Box from "@mui/material/Box";
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import ListItemIcon from '@mui/material/ListItemIcon';
import CancelIcon from '@mui/icons-material/Cancel';
import {styled} from "@mui/material/styles";
import DashboardPieChart from "../components/dashboard-charts/dashboard-pie-chart";

// TODO remove
const Item = styled('div')(({theme}) => ({
    backgroundColor: '#fff',
    border: '1px solid',
    borderColor: '#ced7e0',
    padding: theme.spacing(1),
    borderRadius: '4px',
    textAlign: 'center',
    ...theme.applyStyles('dark', {
        backgroundColor: '#1A2027',
        borderColor: '#444d58',
    }),
}));

const Dashboard = () => {
    const theme = useTheme();

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
                    <Card sx={{p: 0}}>
                        <CardContent sx={{pt: 1, pb: 1}}>
                            <Typography variant="h6">Tests: 7</Typography>
                        </CardContent>
                        <Divider/>
                        <CardContent sx={{p: 0, ":last-child": {padding: 0}}}>
                            <List sx={{p: 0}}>
                                <ListItem disablePadding>
                                    <ListItemButton>
                                        <ListItemIcon>
                                            <CancelIcon sx={{color: theme.custom.graphColors.failed}}/>
                                        </ListItemIcon>
                                        <ListItemText primary="1" secondary="Failed"/>
                                    </ListItemButton>
                                </ListItem>
                                <ListItem disablePadding>
                                    <ListItemButton component="a" href="#simple-list">
                                        <ListItemIcon>
                                            <CancelIcon sx={{color: theme.custom.graphColors.expected_failed}}/>
                                        </ListItemIcon>
                                        <ListItemText primary="1" secondary="Expected Failed"/>
                                    </ListItemButton>
                                </ListItem>
                            </List>
                        </CardContent>
                    </Card>
                </Grid>
                <Grid size={3}>
                    <Card>
                        <CardContent
                            sx={{pt: 1, pb: 1}}
                        >
                            <Typography variant="h6">Breakdown</Typography>
                        </CardContent>
                        <Divider/>
                        <CardContent
                            sx={{pt: 1, pb: 1}}
                        >
                            <DashboardPieChart />
                        </CardContent>
                    </Card>

                </Grid>
                <Grid size={6}>
                    <Item>size=6</Item>
                </Grid>
                <Grid size={8}>
                    <Card>
                        <CardContent
                            sx={{pt: 1, pb: 1}}
                        >
                            <Typography variant="h6">My Card</Typography>
                        </CardContent>
                        <Divider/>
                        <CardContent
                            sx={{pt: 1, pb: 1}}
                        >
                            <Typography>Foobar content card.</Typography>
                        </CardContent>
                    </Card>
                </Grid>
            </Grid>
        </Box>
    );
};
export default Dashboard;
