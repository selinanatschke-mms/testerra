import {type RouteHandle, routesConfig} from "../../router/mainRouter.tsx";
import {Link, useLocation} from "react-router-dom";
import Toolbar from "@mui/material/Toolbar";
import Box from "@mui/material/Box";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemText from "@mui/material/ListItemText";
import Drawer from "@mui/material/Drawer";

import "./MainNavigation.module.scss";
import {useEffect} from "react";

const MainNavigation = () => {

    // https://mui.com/material-ui/react-drawer/#clipped-under-the-app-bar
    // https://mui.com/material-ui/react-drawer/#responsive-drawer

    const menuRoutes = routesConfig[0].children || [];
    const location = useLocation();
    const drawerWidth = 240;

    useEffect(() => {
        console.log('Pfad hat sich geändert zu:', location.pathname);
        console.table(location); // Zeigt die Daten schick als Tabelle an
    }, [location]);

    return (
        <>
            <Drawer
                variant="permanent"
                sx={{
                    width: drawerWidth,
                    flexShrink: 0,
                    [`& .MuiDrawer-paper`]: {width: drawerWidth, boxSizing: 'border-box'},
                }}
            >
                <Toolbar/>
                <Box sx={{overflow: 'auto'}}>
                    <List>
                        {menuRoutes
                            .filter((route) => (route.handle as RouteHandle)?.show)
                            .map((route) => {
                                const path = route.index ? "/" : `/${route.path}`;
                                const label = (route.handle as RouteHandle)?.label;
                                return (
                                    <ListItem
                                        disablePadding
                                        qa-item={'menu-' + label}
                                        key={path}
                                    >
                                        <ListItemButton
                                            component={Link}
                                            to={path}
                                            className="menu-item"
                                            selected={location.pathname === route.path}
                                            // sx={{
                                            //     '&.Mui-selected': {
                                            //         backgroundColor: 'primary.light',
                                            //         color: 'primary.main',
                                            //         '&:hover': {
                                            //             backgroundColor: 'primary.light',
                                            //         },
                                            //         '& .MuiListItemIcon-root': {
                                            //             color: 'primary.main',
                                            //         },
                                            //     },
                                            // }}
                                        >
                                            <ListItemText primary={label}/>
                                        </ListItemButton>
                                    </ListItem>
                                );
                            })
                        }
                    </List>

                </Box>
            </Drawer>
        </>
    );
};
export default MainNavigation;
