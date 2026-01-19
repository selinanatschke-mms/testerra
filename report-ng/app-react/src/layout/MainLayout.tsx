import {Outlet} from 'react-router-dom';

import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import MainNavigation from "../components/navigation/MainNavigation.tsx";

import {reportTheme} from "./reportTheme.tsx";
import {ThemeProvider} from "@mui/material/styles";
import {Stack} from "@mui/material";

const MainLayout = () => {

    return (

        <ThemeProvider theme={reportTheme}>
            <CssBaseline/>
            <Box sx={{
                display: 'flex',
            }}
            >
                <MainNavigation/>

                <Box
                    component="main"
                    sx={{
                        flexGrow: 1,
                        overflow: 'auto',
                    }}
                >
                    <Stack
                        spacing={2}
                        sx={{
                            alignItems: 'center',
                            mx: 3,
                            pb: 5,
                            mt: {xs: 8, md: 2},
                        }}
                    >
                        <Outlet/>
                    </Stack>
                </Box>
            </Box>
        </ThemeProvider>

    );
};
export default MainLayout;
