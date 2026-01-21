import {Box, FormControl, MenuItem} from "@mui/material";
import InputLabel from "@mui/material/InputLabel";
import Select from "@mui/material/Select";

type SelectInputProps = {
    label: string,
    value: number,
    onChange: (value: number) => void,
    menuItems: { value: number, label: string }[];
    sx: any;
}

const SelectInput = ({label, value, onChange, menuItems, sx}: SelectInputProps) => {

    return (
        <Box sx={sx}>
            <FormControl fullWidth>
                <InputLabel id="demo-simple-select-label">{label}</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={value}
                    label={label}
                    onChange={e => onChange?.(e.target.value)}
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

export default SelectInput;
