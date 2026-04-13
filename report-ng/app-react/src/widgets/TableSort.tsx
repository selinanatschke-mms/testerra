import Box from "@mui/material/Box";
import {visuallyHidden} from "@mui/utils";
import TableSortLabel from "@mui/material/TableSortLabel";
import type {OrderDirection, SortableColumn} from "../hooks/useTestListSort";

interface TableSortProps {
    orderBy: SortableColumn;
    orderDirection: OrderDirection;
    onRequestSort: (property: SortableColumn) => void;
    headerProperty: SortableColumn;
    label: string;
}

const TableSort = ({orderBy, orderDirection, onRequestSort, headerProperty, label}: TableSortProps ) => {
    return (
        <TableSortLabel active={orderBy === headerProperty}
                        direction={orderBy === headerProperty ? orderDirection : "asc"}
                        onClick={() => onRequestSort(headerProperty)}>
            {label}
            {orderBy === headerProperty && (
                <Box component="span" sx={visuallyHidden}>
                    {orderDirection === "desc" ? "sorted descending" : "sorted ascending"}
                </Box>
            )}
        </TableSortLabel>
    );
};
export default TableSort;
