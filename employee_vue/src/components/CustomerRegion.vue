<template>
  <div>
<!--    <el-row>-->
<!--      <el-col :span="12">-->
<!--        <div id="chart" style="width: 500px; height: 400px"></div>-->
<!--      </el-col>-->
<!--      <el-col :span="12">-->
<!--        <div id="pie" style="width: 500px; height: 400px"></div>-->
<!--      </el-col>-->
<!--    </el-row>-->

    <el-row>
      <el-col :span="14">
        <div id="chart" style="width: 700px; height: 400px"></div>
      </el-col>
      <el-col :span="10">
        <div id="chart2" style="width: 500px; height: 400px"></div>
      </el-col>
    </el-row>
    <el-button type="primary" style="margin-left: 5px" @click="loadGet">显示表格</el-button>
    <el-table :data="tableData">
      <el-table-column prop="地区" label="地区" width="120" />
      <el-table-column prop="订货量" label="订货量" width="120" />
    </el-table>

  </div>
</template>
<script>

import * as echarts from 'echarts'

export default {
  name: "CustomerRegion",
  data(){
    return{
      tableData:[],
    }
  },
  mounted() {
    var option = {
      title: {
        text: '不同地区客户的订货量',
        subtext: '2024年',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ['东北', '华北', '华南', '华东', '西北', '西南']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [],
          type: 'line'
        }
      ]
    };
    var chartDom = document.getElementById('chart');
    var myChart = echarts.init(chartDom);

    this.$axios.get("http://localhost:8090/客户地区订货量/bar").then(res => res.data).then(res => {

      option.series[0].data=res.data

      myChart.setOption(option);
      option && myChart.setOption(option);
    })

// ***************************************************************************************************************************

    var option2 = {
      title: {
        text: '不同地区客户的订货量',
        subtext: '2024年',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ['东北', '华北', '华南', '华东', '西北', '西南']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [],
          type: 'bar'
        }
      ]
    };
    var chartDom1 = document.getElementById('chart2');
    var myChart1 = echarts.init(chartDom1);
    this.$axios.get("http://localhost:8090/客户地区订货量/bar").then(res => res.data).then(res => {

      option2.series[0].data=res.data

      myChart.setOption(option2);
      option2 && myChart1.setOption(option);
    })
  },
  methods:{
    loadGet() {
      this.$axios.get('http://localhost:8090/客户地区订货量/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },
  }
}
</script>
<style scoped>
</style>
