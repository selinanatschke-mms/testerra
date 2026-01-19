import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';

const Item = styled('div')(({ theme }) => ({
    backgroundColor: '#fff',
    border: '1px solid',
    borderColor: '#ced7e0',
    padding: theme.spacing(1),
    borderRadius: '4px',
    textAlign: 'center',
    ...theme.applyStyles('dark', {
        backgroundColor: '#1A2027',
        borderColor: '#444d58',
    }),
}));

const About = () => {


    return (

        <>
            <Grid container spacing={2}>
                <Grid size={8}>
                    <Item>size=8</Item>
                </Grid>
                <Grid size={4}>
                    <Item>size=4</Item>
                </Grid>
                <Grid size={4}>
                    <Item>size=4</Item>
                </Grid>
                <Grid size={8}>
                    <Item>size=8</Item>
                </Grid>
            </Grid>
        </>

    );
};
export default About;
