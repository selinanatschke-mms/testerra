import {useState} from "react";
import TextField from "@mui/material/TextField";
import SearchIcon from "@mui/icons-material/Search";
import InputAdornment from "@mui/material/InputAdornment";

type SearchInputProps = {
    currentTexts: string[];
    onConfirm: (newTexts: string[]) => void;
    onSearchTextChange?: (text: string) => void;
};

const SearchInput = ({currentTexts, onConfirm, onSearchTextChange,}: SearchInputProps) => {
    const [searchText, setSearchText] = useState("");

    return (
        <TextField
            label="Search"
            value={searchText}
            onChange={(e) => {
                setSearchText(e.target.value);
                onSearchTextChange?.(e.target.value);
            }}
            onKeyDown={(e) => {
                if (e.key === "Enter") {
                    const newCustomText = [...currentTexts, searchText.trim()]
                        .filter((v, i, a) => a.indexOf(v) === i,); // avoid duplicates
                    onConfirm(newCustomText);
                    setSearchText("");
                }
            }}
            slotProps={{
                input: {
                    startAdornment: (
                        <InputAdornment position="start">
                            <SearchIcon sx={{color: "action.active"}}/>
                        </InputAdornment>
                    ),
                },
            }}
            sx={{width: "100%"}}
        />
    );
};

export default SearchInput;
