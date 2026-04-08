import Chip from "@mui/material/Chip";
import type {SxProps, Theme} from '@mui/material/styles';
import type {FilterColor} from "../../hooks/useTestListFilters";

type ReportChipProps = {
    label: string,
    sx?: SxProps<Theme>,
    handleDelete?: () => void;
    color?: FilterColor
}

const ReportChip = ({label, sx, handleDelete, color}: ReportChipProps) => {
    return (
        <Chip label={label} sx={sx} onDelete={handleDelete} color={color}/>
    );
}

export default ReportChip;
