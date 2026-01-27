import {Box, FormControl, MenuItem} from "@mui/material";
import InputLabel from "@mui/material/InputLabel";
import Select from "@mui/material/Select";
import ReportChip from "../report-chip/report-chip";
import type {SxProps, Theme} from "@mui/material/styles";
import {useTheme} from '@mui/material/styles';
import type {Status} from "../../layout/reportTheme";

type SelectInputProps = {
    label: string
    selectedStatuses?: Status[] | [],
    onChange: (value: Status[]) => void;
    menuItems: { value: Status, label: string }[];
    sx?: SxProps<Theme>;
}

const StatusSelectInput = ({label, selectedStatuses, onChange, menuItems, sx}: SelectInputProps) => {
    const theme = useTheme();

    return (
        <Box sx={sx}>
            <FormControl fullWidth>
                <InputLabel>{label}</InputLabel>
                <Select
                    multiple
                    value={selectedStatuses}
                    label={label}
                    onChange={(e) =>
                        onChange(e.target.value as Status[])
                    }
                    sx={{height: "56px"}}
                >
                    {menuItems.map(menuItem => (
                        <MenuItem key={menuItem.value} value={menuItem.value}>
                            <ReportChip label={menuItem.label}
                                        sx={{background: theme.custom.statusColors[menuItem.value], color: "white"}}/>
                        </MenuItem>
                    ))}
                </Select>
            </FormControl>
        </Box>
    );
}

export default StatusSelectInput;
