<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <div>{{beforeMount()}}</div>
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
        <el-select v-model="类别名称" filterable placeholder="请选择类别" style="margin-left: 5px">
          <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询</el-button>
      </div>
      <el-table :data="tableData">
        <el-table-column prop="类别名称" label="类别名称" width="100" />
        <el-table-column prop="供应商id" label="供应商id" width="140" />
        <el-table-column prop="数量" label="数量" width="120"/>
      </el-table>
    </div>
  </el-scrollbar>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      类别名称:'',
      供应商id:'',
      数量:'',
      options:[{
        value: '饮料',
        label: '饮料'
      }, {
        value: '调味品',
        label: '调味品'
      }, {
        value: '点心',
        label: '点心'
      }, {
        value: '日用品',
        label: '日用品'
      }, {
        value: '谷类/麦片',
        label: '谷类/麦片'
      },{
        value: '肉/家禽',
        label: '肉/家禽'
      },{
        value: '特制品',
        label: '特制品'
      },{
        value: '海鲜',
        label: '海鲜'
      },{
        value: null,
        label: '请选择类别'
      }]
    };
  },

  methods: {

    loadGet() {
      this.$axios.get('http://localhost:8090/类别供应商数量/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },
    loadPost() {
      console.log(this.类别名称)
      this.$axios.post('http://localhost:8090/类别供应商数量/listP', {
            "类别名称":this.类别名称
          }
      ).then(res => res.data).then(res => res.data).then(res => {
        console.log(this.类别名称)
        console.log(232)
        console.log(res)
        this.tableData = res
      })
    },
    beforeMount() {
      // this.loadGet();
      //this.loadPost();
    }
  }
};
</script>