import {useTheme} from "@mui/material";
import React from "react";
import ReportCard from "../../widgets/report-card/report-card";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import CancelIcon from "@mui/icons-material/Cancel";
import ListItemText from "@mui/material/ListItemText";

const DashboardTestResultsCard: React.FC = () => {
    const theme = useTheme();

    return (
        <ReportCard label="Tests: 7" sx={{p: 0, ":last-child": {padding: 0}}}>
            <List sx={{p: 0}}>
                <ListItem disablePadding>
                    <ListItemButton>
                        <ListItemIcon>
                            <CancelIcon sx={{color: theme.custom.statusColors.failed}}/>
                        </ListItemIcon>
                        <ListItemText primary="1" secondary="Failed"/>
                    </ListItemButton>
                </ListItem>
                <ListItem disablePadding>
                    <ListItemButton>
                        <ListItemIcon>
                            <CancelIcon sx={{color: theme.custom.statusColors.expected_failed}}/>
                        </ListItemIcon>
                        <ListItemText primary="1" secondary="Expected Failed"/>
                    </ListItemButton>
                </ListItem>
            </List>
        </ReportCard>
    );
};
export default DashboardTestResultsCard;
