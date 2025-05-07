<template>
  <div>
    <el-row>
      <el-col :span="14">
        <div id="chart2" style="width: 650px; height: 400px"></div>
      </el-col>
      <el-col :span="10">
        <div id="chart1" style="width: 500px; height: 400px"></div>
      </el-col>
    </el-row>
    <el-button type="primary" style="margin-left: 5px;margin-bottom: 5px" @click="loadGet1">显示发往不同地区运货量</el-button>
    <el-table :data="tableData1">
      <el-table-column prop="货主地区" label="货主地区" width="120" />
      <el-table-column prop="订货量" label="订货量" width="120" />
    </el-table>
        <el-row>
          <el-col :span="14">
            <div id="chart4" style="width: 650px; height: 400px"></div>
          </el-col>
          <el-col :span="10">
            <div id="chart3" style="width: 500px; height: 400px"></div>
          </el-col>
        </el-row>
    <el-button type="primary" style="margin-left: 5px;margin-bottom: 5px" @click="loadGet2">显示不同季节运货量</el-button>
    <el-table :data="tableData2">
      <el-table-column prop="季节" label="季节" width="120" />
      <el-table-column prop="运货量" label="运货量" width="120" />
    </el-table>
  </div>

</template>
<script>

import * as echarts from 'echarts'

export default {
  name: "RegionSeason",
  data(){
    return{

      tableData1:[],
      tableData2:[],
    }
  },
  mounted() {
    //折线图1
    var option1 = {
      title: {
        text: '发往不同地区的运货量',
        subtext: '折线图',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ["东北", "华北", "华南", "华东","华中","西北","西南"]
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
    var chartDom1 = document.getElementById('chart1');
    var myChart1 = echarts.init(chartDom1);

    this.$axios.get("http://localhost:8090/不同地区运货量/bar").then(res => res.data).then(res => {

      option1.series[0].data=res.data

      myChart1.setOption(option1);
    })

// ******************************************************************************************
    var option2 = {
      title: {
        text: '发往不同地区的运货量',
        subtext: '柱状图',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ["东北", "华北", "华南", "华东","华中","西北","西南"]
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
    var chartDom2 = document.getElementById('chart2');
    var myChart2 = echarts.init(chartDom2);
    this.$axios.get("http://localhost:8090/不同地区运货量/bar").then(res => res.data).then(res => {

      option2.series[0].data=res.data

      myChart2.setOption(option2);
    })
    // ************************************************
    var option3 = {
      title: {
        text: '不同季节运货量',
        subtext: '折线图',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ["春", "夏", "秋", "冬"]
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
    var chartDom3 = document.getElementById('chart3');
    var myChart3 = echarts.init(chartDom3);

    this.$axios.get("http://localhost:8090/不同季节运货量/bar").then(res => res.data).then(res => {

      option3.series[0].data=res.data

      myChart3.setOption(option3);
    })

// ******************************************************************************************
    let option4 = {
      title: {
        text: '不同季节运货量',
        subtext: '柱状图',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ["春", "夏", "秋", "冬"]
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
    var chartDom4 = document.getElementById('chart4');
    var myChart4 = echarts.init(chartDom4);
    this.$axios.get("http://localhost:8090/不同季节运货量/bar").then(res => res.data).then(res => {

      option4.series[0].data=res.data
      myChart4.setOption(option4);
    })
  },
  methods:{
    loadGet1() {
      this.$axios.get('http://localhost:8090/不同地区运货量/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData1 = res
      })
    },
    loadGet2() {
      this.$axios.get('http://localhost:8090/不同季节运货量/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData2 = res
      })
    },
  }
}
</script>
<style scoped>
</style>
