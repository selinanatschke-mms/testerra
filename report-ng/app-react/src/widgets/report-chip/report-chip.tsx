import type {ChipProps} from "@mui/material/Chip";
import Chip from "@mui/material/Chip";
import type {SxProps, Theme} from '@mui/material/styles';

type ReportChipProps = {
    label: string,
    sx?: SxProps<Theme>,
    handleDelete?: () => void;
    type?: "status" | "class" | "customText" | "customFilter";
}

const ReportChip = ({label, sx, handleDelete, type}: ReportChipProps) => {
    let color: ChipProps["color"];

    if (type === "status") {
        color = "blue"
    } else if (type === "class") {
        color = "green"
    } else if (type === "customText") {
        color = "purple"
    } else if (type === "customFilter") {
        label = "Custom Filter"
    } else {
        color = "default"
    }

    return (
        <Chip label={label} sx={sx} onDelete={handleDelete} color={color}/>
    );
}

export default ReportChip;
