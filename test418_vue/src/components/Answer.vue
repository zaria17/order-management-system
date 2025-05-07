<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询</el-button>
        <!--        <el-button type="primary" @click="add">新增</el-button>-->
      </div>
      <el-table :data="tableData">
        <el-table-column prop="客户id" label="客户id" width="100" />
        <el-table-column prop="雇员id" label="雇员id" width="140" />
        <el-table-column prop="咨询时间" label="咨询时间" width="120"/>
        <el-table-column prop="咨询内容" label="咨询内容" width="100" />
        <el-table-column prop="回复时间" label="回复时间" width="100" />
        <el-table-column prop="回复内容" label="回复内容" width="100" />
      </el-table>
    </div>
  </el-scrollbar>
</template>

<script>

export default {
  name: "Answer",
  data() {
    return {
      user : JSON.parse(sessionStorage.getItem('CurUser')),
      tableData: [],
      客户id:'',
    }
  },
  methods: {

    loadGet() {
      this.$axios.get('http://localhost:8090/咨询记录/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },

    loadPost() {
      this.$axios.post('http://localhost:8090/咨询记录/listP1', {
            "客户id":this.user.客户id
          }
      ).then(res => res.data).then(res => res.data).then(res => {
        console.log(232)
        console.log(res)
        this.tableData = res
      })
    },
    beforeMount() {
      this.loadGet();
      //this.loadPost();
    }
  }
}
</script>

<style>
</style>