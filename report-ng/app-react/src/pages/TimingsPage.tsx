import Box from "@mui/material/Box";
import TabNavigation from "../widgets/tab-navigation/tab-navigation";
import {Outlet} from 'react-router-dom';
import OpenInNewIcon from '@mui/icons-material/OpenInNew';
import ListIcon from '@mui/icons-material/List';

// TODO get from router
const tabs = [
    {label: "Tests", route: "test-timings", icon: <ListIcon />},
    {label: "Sessions", route: "sessions", icon: <OpenInNewIcon />}
];

const TimingsPage = () => {

    return (
        <Box sx={{width: '100%', p: '24px 32px'}}>
            <TabNavigation tabs={tabs}/>

            <Box sx={{p: '24px 32px'}}>
                {/* Placeholder to render child component from router */}
                <Outlet/>
            </Box>
        </Box>
    );
};
export default TimingsPage;
