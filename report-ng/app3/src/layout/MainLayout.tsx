import {Outlet} from 'react-router-dom';

import Box from '@mui/material/Box';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';


import '../styles/index.css'
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import MainNavigation from "../components/navigation/MainNavigation.tsx";

import {reportTheme} from "./reportTheme.tsx";
import {ThemeProvider} from "@mui/material/styles";


const MainLayout = () => {

    return (

        // <div style={{display: 'flex', flexDirection: 'column', minHeight: '100vh'}}>
        //
        //     <MainNavigation/>
        //
        //     <main style={{padding: '20px', flex: 1}}>
        //         <Outlet/>
        //     </main>
        //
        //     <footer style={{padding: '1rem', background: '#333', color: 'white'}}>
        //         © 2024 Meine React App
        //     </footer>
        // </div>

        <Box sx={{display: 'flex'}}>
            <ThemeProvider theme={reportTheme}>
                <CssBaseline/>
                <AppBar position="fixed" sx={{zIndex: (theme) => theme.zIndex.drawer + 1}}>
                    <Toolbar>
                        <Typography variant="h6" noWrap component="div">
                            Testerra
                        </Typography>
                    </Toolbar>
                </AppBar>
                <MainNavigation/>


                <Box
                    sx={{ width: '100%', maxWidth: { sm: '100%', md: '1700px' } }}
                >
                    <Outlet/>
                </Box>
            </ThemeProvider>
        </Box>

    );
};

export default MainLayout;
