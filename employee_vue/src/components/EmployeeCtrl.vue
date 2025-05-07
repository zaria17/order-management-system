<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
        <el-input v-model="雇员id" placeholder="请输入雇员id：" suffix-icon="el-icon-search" style="width: 200px"></el-input>
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询</el-button>
        <el-button type="primary" style="margin-left: 5px" @click="loadGet">查看全部</el-button>
        <!--        <el-button type="primary" @click="add">新增</el-button>-->
      </div>
      <el-table :data="tableData">
        <el-table-column prop="雇员id" label="雇员id" width="100" />
        <el-table-column prop="姓氏" label="姓氏" width="140" />
        <el-table-column prop="名字" label="名字" width="120"/>
        <el-table-column prop="职务" label="职务" width="100" />
        <el-table-column prop="尊称" label="尊称" width="100" />
        <el-table-column prop="出生日期" label="出生日期" width="100" />
        <el-table-column prop="雇用日期" label="雇用日期" width="100" />
        <el-table-column prop="地址" label="地址" width="100" />
        <el-table-column prop="城市" label="城市" width="100" />
        <el-table-column prop="地区" label="地区" width="100" />
        <el-table-column prop="邮政编码" label="邮政编码" width="100" />
        <el-table-column prop="国家" label="国家" width="100" />
        <el-table-column prop="家庭电话" label="家庭电话" width="100" />
        <el-table-column  prop="照片" label="照片" width="120">
          <template slot-scope="scope">
            <img :src="scope.row.照片" alt="Image" style="width: 120px; height: 160px"/>
          </template>
        </el-table-column>
        <el-table-column prop="operate" label="操作" width="200">
          <template slot-scope="scope">
            <!--            <el-button size="small" type="success" @click="mod(scope.row)">编辑</el-button>-->
            <el-popconfirm
                title="确定删除吗？"
                @confirm="del(scope.row.雇员id)"
                style="margin-left: 5px"
            >
              <el-button slot="reference" size="small" type="danger" >删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </el-scrollbar>
</template>

<script>

export default {
  name: "SupplierCtrl",
  data() {
    return {
      tableData: [],
      雇员id:'',
    }
  },
  methods: {
    del(雇员id) {
      console.log(雇员id)
      this.$axios.get('http://localhost:8090/雇员/delete?雇员id='+雇员id).then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
        if (res.code = 200) {
          //alert('suc')
          this.$message({
            message: '操作成功！',
            type: 'success'
          });
          this.centerDialogVisible = false
          this.loadPost()
        } else {
          this.$message({
            message: '操作失败！',
            type: 'error'
          });
        }
      })
    },



    loadGet() {
      this.$axios.get('http://localhost:8090/雇员/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },

    loadPost() {
      this.$axios.post('http://localhost:8090/雇员/listP2', {
            "雇员id":this.雇员id
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