import {createRoot} from 'react-dom/client'

import React from "react"
import {QueryClient, QueryClientProvider} from "react-query";
import {RouterProvider} from "react-router-dom";
import {router} from "./router/mainRouter.tsx";

const client = new QueryClient()

createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <QueryClientProvider client={client}>
            <RouterProvider router={router}/>
        </QueryClientProvider>
    </React.StrictMode>
)
