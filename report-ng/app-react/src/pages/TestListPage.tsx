import Box from "@mui/material/Box";
import {Grid, Switch} from "@mui/material";
import StatusSelectInput from "../widgets/select-input/status-select-input";
import FormControlLabel from "@mui/material/FormControlLabel";
import TextField from '@mui/material/TextField';
import SearchIcon from '@mui/icons-material/Search';
import InputAdornment from '@mui/material/InputAdornment';
import MultiSelectInput from "../widgets/select-input/multi-select-input";
import {useTestListFilters} from "../hooks/useTestListFilters";
import SelectedFiltersChips from "../components/selected-filter-chips";

const TestListPage = () => {

    const {
        statusMenuItems,
        classMenuItems,
        selectedStatuses,
        selectedClasses,
        handleStatusChange,
        handleClassChange,
        configurationMethodsChecked,
        handleConfigurationMethodsChecked,
        handleDelete,
        handleClearAllClick
    } = useTestListFilters();

    return (
        <Box
            sx={{width: '100%', maxWidth: {sm: '100%', md: '1700px'}}}
        >
            <Grid
                container
                spacing={3}
                columns={12}
            >
                <Grid size={2}>
                    <StatusSelectInput label="Status" selectedStatuses={selectedStatuses} onChange={handleStatusChange}
                                       menuItems={statusMenuItems}/>
                </Grid>
                <Grid size={3}>
                    <MultiSelectInput label="Class" values={selectedClasses} onChange={handleClassChange}
                                      menuItems={classMenuItems}
                                      renderValue={(selected: string[]) => {
                                          if (!selected?.length) return "";
                                          if (selected.length === 1) return "1 class selected";
                                          return `${selected.length} classes selected`;
                                      }}/>
                </Grid>
                <Grid size={5}>
                    <TextField
                        label="Search"
                        slotProps={{
                            input: {
                                startAdornment: (
                                    <InputAdornment position="start">
                                        <SearchIcon sx={{color: 'action.active'}}/>
                                    </InputAdornment>
                                ),
                            },
                        }}
                        sx={{width: "100%"}}
                    />
                </Grid>
                <Grid size={2}>
                    <FormControlLabel control={<Switch defaultChecked value={configurationMethodsChecked}
                                                       onChange={handleConfigurationMethodsChecked}/>}
                                      label="Show configuration methods"/>
                </Grid>
                <Grid size={12}>
                    <SelectedFiltersChips selectedStatuses={selectedStatuses}
                                          selectedClasses={selectedClasses}
                                          handleDelete={handleDelete}
                                          handleClearAllClick={handleClearAllClick}/>

                </Grid>
            </Grid>
        </Box>

    );
};
export default TestListPage;
