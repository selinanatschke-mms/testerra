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
import TestList from "../components/TestList";
import {useState} from "react";

const TestListPage = () => {

    const {
        statusMenuItems,
        classMenuItems,
        filters,
        setFilter,
        configurationMethodsChecked,
        handleConfigurationMethodsChecked,
        handleDelete,
        clearAll,
    } = useTestListFilters();

    const selectedStatuses = filters.status ?? [];
    const selectedClasses = filters.class ?? [];

    // local search state
    const [searchText, setSearchText] = useState("");

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
                    <StatusSelectInput label="Status" selectedStatuses={selectedStatuses}
                                       onChange={(newStatuses) => setFilter("status", newStatuses)}
                                       menuItems={statusMenuItems}/>
                </Grid>
                <Grid size={3}>
                    <MultiSelectInput label="Class"
                                      values={selectedClasses}
                                      onChange={(newClasses) => setFilter("class", newClasses)}
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
                        value={searchText}
                        onChange={e => setSearchText(e.target.value)}
                        onKeyDown={e => {
                            if (e.key === "Enter") {
                                // add new word to text Chips
                                const prevCustomText = filters.customText ?? [];
                                const newCustomText = [...prevCustomText, searchText.trim()]
                                    .filter((v, i, a) => a.indexOf(v) === i); // avoid duplicates
                                setFilter("customText", newCustomText);
                                setSearchText("");
                            }
                        }}
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
                <Grid size={12} minHeight={36}>
                    <SelectedFiltersChips selectedFilters={filters}
                                          handleDelete={handleDelete}
                                          handleClearAllClick={clearAll}/>

                </Grid>
                <Grid size={12} >
                    <TestList filters={filters} searchText={searchText} showConfigurationMethods={configurationMethodsChecked}/>
                </Grid>
            </Grid>
        </Box>

    );
};
export default TestListPage;
