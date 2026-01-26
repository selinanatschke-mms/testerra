import {createTheme} from "@mui/material";

const statusColors = {
    passed: '#417336',
    skipped: '#f7af3e',
    failed: '#e63946',
    crashed: '#5d6f81',
    running: '#0089b6',
    failed_minor: '#f7af3e',
    expected_failed: '#4f031b'
}

export const reportTheme = createTheme({
    custom: {
        statusColors,
    },
    cssVariables: {
        nativeColor: true,
    },
    palette: {
        primary: {
            main: "#4b4b4b"
        },
        secondary: {
            main: "#f6a821"
        },
        background: {
            default: '#fafafa'
        }
    },
});

declare module "@mui/material/styles" {
    // expand theme to add "custom" (necessary to use colors from theme in other files)
    interface Theme {
        custom: {
            statusColors: {
                passed: string;
                skipped: string;
                failed: string;
                crashed: string;
                running: string;
                failed_minor: string;
                expected_failed: string;
            };
        };
    }

    // expand "ThemeOptions" to add "statusColors"
    interface ThemeOptions {
        custom?: {
            statusColors?: {
                passed?: string;
                skipped?: string;
                failed?: string;
                crashed?: string;
                running?: string;
                failed_minor?: string;
                expected_failed?: string;
            };
        };
    }
}
