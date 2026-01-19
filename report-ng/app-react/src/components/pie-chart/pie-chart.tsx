import React from 'react';
import ReactECharts from 'echarts-for-react';
import {useTheme} from "@mui/material";

const PieChart: React.FC = () => {
    const theme = useTheme();

    const option = {
        tooltip: {
            formatter: '{b}: {c}'
        },
        label: {
            show: false
        },
        labelLine: {
            show: false
        },
        series: [
            {
                name: 'Access From',
                type: 'pie',
                radius: '50%',
                data: [
                    {value: 3, name: 'Passed', itemStyle: {color: theme.custom.graphColors.passed}},
                    {value: 1, name: 'Failed', itemStyle: {color: theme.custom.graphColors.failed}},
                    {value: 1, name: 'Expected Failed', itemStyle: {color: theme.custom.graphColors.expected_failed}},
                    {value: 1, name: 'Skipped', itemStyle: {color: theme.custom.graphColors.skipped}},
                ]
            }
        ]
    };

    return <ReactECharts option={option}/>;
};

export default PieChart;