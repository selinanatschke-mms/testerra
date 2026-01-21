
import {createHashRouter, type RouteObject, Navigate} from 'react-router-dom';
import MainLayout from "../layout/MainLayout.tsx";
import About from "../pages/About.tsx";
import Tests from "../pages/Tests.tsx";
import TimingsPage from "../pages/TimingsPage.tsx";
import Dashboard from "../pages/Dashboard.tsx";
import MethodDetailsPage from "../pages/MethodDetailsPage.tsx";
import NotFoundPage from "../pages/NotFoundPage.tsx";

import HomeRoundedIcon from '@mui/icons-material/HomeRounded';
import AnalyticsRoundedIcon from '@mui/icons-material/AnalyticsRounded';
import InfoRoundedIcon from '@mui/icons-material/InfoRounded';
import OpenInNewIcon from '@mui/icons-material/OpenInNew';
import ListIcon from '@mui/icons-material/List';
import type {JSX} from "react";
import TestTimings from "../components/timings-tab-components/test-timings";

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
            },
            {
                path: "timings",
                element: <TimingsPage/>,
                handle: {label: "Timings", show: true, icon: <AnalyticsRoundedIcon />} as RouteHandle,
                children: [
                    // makes sure that never only /timings is rendered but always /timings/test-timings
                    {
                        index: true,
                        element: <Navigate to="test-timings" replace />
                    },
                    {
                        path: "test-timings",
                        element: <TestTimings/>,
                        handle: {label: "Test Timings", show: true, icon: <ListIcon />} as RouteHandle
                    },
                    {
                        path: "sessions",
                        element: <Dashboard/>,
                        handle: {label: "Sessions", show: true, icon: <OpenInNewIcon />} as RouteHandle
                    },
                ]
            },
            {
                path: "method/:methodId",
                element: <MethodDetailsPage />
            },
            {
                path: '*',
                element: <NotFoundPage />,
            },
        ],
    },
];

export const router = createHashRouter(routesConfig);
