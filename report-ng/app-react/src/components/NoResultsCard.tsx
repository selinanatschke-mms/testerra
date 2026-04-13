import {Card, CardContent, Stack, Typography} from "@mui/material";
import FindInPageIcon from '@mui/icons-material/FindInPage';

const NoResultsCard = () => {
    return (
        <Card>
            <CardContent>
                <Stack direction="column" spacing={2} sx={{alignItems: "center", p: 2}}>
                    <Stack direction="row" spacing={1}>
                        <FindInPageIcon fontSize="large"/>
                        <Typography variant="h4"> No methods matching this criteria </Typography>
                    </Stack>
                    <Typography variant="subtitle1">Please note, that your filter criteria may only match configuration methods.</Typography>
                </Stack>
            </CardContent>
        </Card>
    );
};
export default NoResultsCard;
