import {Box, FormControl, MenuItem} from "@mui/material";
import InputLabel from "@mui/material/InputLabel";
import Select from "@mui/material/Select";
import type {SxProps, Theme} from "@mui/material/styles";

type MultiSelectInputProps = {
    label: string,
    values: string[],
    onChange: (value: string[]) => void;
    menuItems: { value: string, label: string }[];
    sx?: SxProps<Theme>;
    renderValue?: (selected: string[]) => React.ReactNode;
}

const MultiSelectInput = ({label, values, onChange, menuItems, sx, renderValue}: MultiSelectInputProps) => {

    return (
        <Box sx={sx}>
            <FormControl fullWidth>
                <InputLabel>{label}</InputLabel>
                <Select
                    multiple
                    value={values}
                    label={label}
                    onChange={(e) => {
                        onChange(e.target.value as unknown as string[]);
                    }}
                    renderValue={renderValue}
                >
                    {menuItems.map(menuItem => (
                        <MenuItem key={menuItem.value} value={menuItem.value}>
                            {menuItem.label}
                        </MenuItem>
                    ))}
                </Select>
            </FormControl>
        </Box>
    );
}

export default MultiSelectInput;
