<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <el-button type="primary" style="margin-left: 5px" @click="beforeMount()">查询</el-button>
      <el-table :data="tableData">
        <el-table-column prop="供应商id" label="供应商ID" width="100" />
        <el-table-column prop="单价总金额" label="单价总金额" width="140" />
      </el-table>
    </div>
  </el-scrollbar>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
    };
  },
  methods: {

    loadGet() {
      this.$axios.get('http://localhost:8090/每家供应商供应产品的单价总金额/list').then(res => res.data).then(res => {
        console.log(res)

        this.tableData = res
      })
    },
    beforeMount() {
      this.loadGet();
    }
  }
};
</script>