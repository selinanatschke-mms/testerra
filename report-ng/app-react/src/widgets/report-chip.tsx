import Chip from "@mui/material/Chip";
import type {SxProps, Theme} from '@mui/material/styles';
import type {ChipColor} from "../hooks/useTestListFilters";

type ReportChipProps = {
    label: string,
    sx?: SxProps<Theme>,
    handleDelete?: () => void;
    color?: ChipColor,
    size?: "medium" | "small"
}

const ReportChip = ({label, sx, handleDelete, color, size}: ReportChipProps) => {
    return (
        <Chip label={label} sx={sx} onDelete={handleDelete} color={color} size={size}/>
    );
}

export default ReportChip;
