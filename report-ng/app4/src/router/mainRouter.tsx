
import {createHashRouter, type RouteObject} from 'react-router-dom';
import MainLayout from "../layout/MainLayout.tsx";
import About from "../pages/About.tsx";
import Tests from "../pages/Tests.tsx";
import Dashboard from "../pages/Dashboard.tsx";
import HomeRoundedIcon from '@mui/icons-material/HomeRounded';
import AnalyticsRoundedIcon from '@mui/icons-material/AnalyticsRounded';
import InfoRoundedIcon from '@mui/icons-material/InfoRounded';
import type {JSX} from "react";

// Custom attributes for menu elements
export interface RouteHandle {
    label: string;
    show: boolean;
    icon: JSX.Element;
}

export const routesConfig: RouteObject[] = [
    {
        path: "/",
        element: <MainLayout/>,
        children: [
            {
                index: true,
                element: <Dashboard/>,
                handle: {label: "Dashboard", show: true, icon: <HomeRoundedIcon />} as RouteHandle
            },
            {
                path: "Tests",
                element: <Tests/>,
                handle: {label: "Tests", show: true, icon: <AnalyticsRoundedIcon />} as RouteHandle
            },
            {
                path: "about",
                element: <About/>,
                handle: {label: "About", show: true, icon: <InfoRoundedIcon />} as RouteHandle
            }
        ],
    },
];

export const router = createHashRouter(routesConfig);
