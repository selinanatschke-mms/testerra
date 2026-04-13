import Chip from "@mui/material/Chip";
import type {SxProps, Theme} from '@mui/material/styles';
import type {ChipColor} from "../hooks/useTestListFilters";
import Tooltip from '@mui/material/Tooltip';

type ReportChipProps = {
    label: string,
    sx?: SxProps<Theme>,
    handleDelete?: () => void;
    color?: ChipColor,
    size?: "medium" | "small",
    tooltipText?: string
}

const ReportChip = ({label, sx, handleDelete, color, size, tooltipText}: ReportChipProps) => {
    return (
        <Tooltip title={tooltipText}>
            <Chip label={label} sx={sx} onDelete={handleDelete} color={color} size={size}/>
        </Tooltip>
    );
}

export default ReportChip;
