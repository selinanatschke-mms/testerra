import React from 'react';
import type {EChartsOption} from 'echarts-for-react';
import ReactECharts from 'echarts-for-react';

export interface EChartProps {
    option: EChartsOption;
}

const EChart: React.FC<EChartProps> = ({option}) => {

    return <ReactECharts option={option}/>;
};

export default EChart;