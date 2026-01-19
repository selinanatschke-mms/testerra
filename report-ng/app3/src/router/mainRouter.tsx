import App from "../App.tsx";
import {createHashRouter, type RouteObject} from 'react-router-dom';
import MainLayout from "../layout/MainLayout.tsx";
import About from "../pages/about/About.tsx";
import ColorDemo from "../pages/colorDemo/ColorDemo.tsx";

// Custom attributes for menu elements
export interface RouteHandle {
    label?: string;
    show?: boolean;
}

export const routesConfig: RouteObject[] = [
    {
        path: "/",
        element: <MainLayout/>,
        children: [
            {
                index: true,
                element: <App/>,
                handle: {label: "Home", show: true} as RouteHandle
            },
            {
                path: "colorDemo",
                element: <ColorDemo/>,
                handle: {label: "ColorDemo", show: true} as RouteHandle
            },
            {
                path: "about",
                element: <About/>,
                handle: {label: "About", show: true} as RouteHandle
            }
        ],
    },
];

export const router = createHashRouter(routesConfig);
