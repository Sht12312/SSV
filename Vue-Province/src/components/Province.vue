<template>
    <div id="chart" style="width: 1000px; height: 600px;"></div>
</template>

<script>
import * as echarts from "echarts";
import axios from "axios";
import { ref, onMounted } from 'vue';

export default {
    name: 'province',
    setup() {
        const data1 = ref(null);

        const fetchData = async () => {
            try {
                const response = await axios.get("http://127.0.0.1:8080/store/province");
                data1.value = response.data;
                console.log("Fetched data", data1.value);
                BarChart(); // 数据加载完成后立即渲染图表
            } catch (error) {
                console.error("Error ", error);
            }
        }

        const BarChart = () => {
            if (!data1.value) {
                return;
            }

            // 确保 chart 元素已经挂载
            if (!document.getElementById('chart')) {
                console.error("Chart container not found");
                return;
            }

            const chart = echarts.init(document.getElementById('chart'));

            const opt = {
                title: {
                    text: 'Province Data',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                xAxis: {
                    type: 'category',
                    data: data1.value.map(province => province.name)
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name: 'Area Code',
                        type: 'bar',
                        data: data1.value.map(province => parseInt(province.area_code))
                    }
                ]
            };

            chart.setOption(opt);
        }

        onMounted(() => {
            fetchData();
        });

        return {
            data1,
            BarChart
        }
    }
}
</script>

<style>
    
</style>
