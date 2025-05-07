<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
        <el-input v-model="订单id" placeholder="请输入订单ID：" suffix-icon="el-icon-search" style="width: 200px"></el-input>
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询</el-button>
        <el-button type="primary" @click="add">新增</el-button>
      </div>
      <el-table :data="tableData">
        <el-table-column prop="订单id" label="订单ID" width="70" />
        <el-table-column prop="产品id" label="产品id" width="100" />
        <el-table-column prop="数量" label="数量" width="70"/>
        <el-table-column prop="产品总金额" label="产品总金额" width="120"/>
        <el-table-column prop="operate" label="操作" width="160">
          <template slot-scope="scope">
            <el-button size="small" type="success" @click="loadPost2(scope.row)">查询</el-button>
            <el-popconfirm
                title="确定删除吗？"
                @confirm="del(scope.row.订单id,scope.row.产品id)"
                style="margin-left: 5px"
            >
              <el-button slot="reference" size="small" type="danger" >删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>

      </el-table>
      <el-table :data="tableData2">
        <el-table-column prop="产品id" label="产品id" width="100" />
        <el-table-column prop="产品名称" label="产品名称" width="100" />
        <el-table-column prop="单位数量" label="单位数量" width="100" />
        <el-table-column prop="单价" label="单价" width="100" />
      </el-table>

      <el-dialog
          title="提示"
          :visible.sync="centerDialogVisible"
          width="30%"
          center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="订单ID" >
            <el-input v-model="form.订单id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="产品ID">
            <el-input v-model="form.产品id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="数量">
            <el-input v-model="form.数量"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false" >取 消</el-button>
    <el-button type="primary" @click="save">确 定</el-button>
  </span>
      </el-dialog>
    </div>
  </el-scrollbar>
</template>

<script>

const vis={
  t1:true,
  t2:false
}

export default {
  name: "Main",
  data() {
    return {
      i:0,
      tableData: [],
      tableData2: [],
      订单id: '',
      产品id:'',
      产品名称:'',
      单位:'',
      单价:'',
      数量:'',
      产品总金额:'',
      orderNumber:'',
      productList: [],
      centerDialogVisible: false,
      form: {
        产品id: '',
        订单id: '',
        数量: '',
        rowId: '1'
      },

    }
  },
  mounted() {
    //this.tableData();
  },
  methods: {
    resetForm() {
      this.$refs.form.resetFields();
    },
    del(订单id,产品id) {
      console.log(订单id)
      console.log(产品id)
      this.$axios.get('http://localhost:8090/订单明细/delete?订单id='+订单id+'&产品id='+产品id).then(res => res.data).then(res => {
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
    mod(row) {
      console.log(row)
      this.centerDialogVisible = true;
      this.$nextTick(() => {
        //赋值到表单
        this.form.订单id = row.订单id
        this.form.产品id = row.产品id
        this.form.数量 = row.数量
        this.form.rowId = row.rowId
      })
    },
    add() {
      this.centerDialogVisible = true;
      this.$nextTick(() => {
        this.resetForm();
      })
    },
    doSave() {
      this.$axios.post('http://localhost:8090/订单明细/save', this.form).then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
        if (res.code = 200) {
          //alert('suc')
          this.$message({
            message: '操作成功！',
            type: 'success'
          });
          this.centerDialogVisible = false
        } else {
          this.$message({
            message: '操作失败！',
            type: 'error'
          });
        }
      })
    },
    doMod() {
      this.$axios.post('http://localhost:8090/订单明细/save', this.form).then(res => res.data).then(res => {
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
          this.resetForm()
        } else {
          this.$message({
            message: '操作失败！',
            type: 'error'
          });
        }
      })
    },
    save() {
      this.$refs.form.validate(valid => {
        if (valid) {
          if (this.form.订单id) {
            console.log(222)
            this.doMod();
          } else {
            console.log(111)
            this.doSave();
          }
        } else {
          console.log('error submit!!!');
          return false;
        }
      });
    },
    loadGet() {
      this.$axios.get('http://localhost:8090/订单明细/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },
    loadPost() {
      this.$axios.post('http://localhost:8090/订单明细/listP', {
            "订单id":this.订单id
          }
      ).then(res => res.data).then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },
    loadPost2(dat) {
      this.$axios.post('http://localhost:8090/产品/listP2', {
        "产品id": dat.产品id
      }).then(res => res.data).then(res => {
        console.log(res)
        this.tableData2=res.data
      })
    },
  },
    // getname(data){
    //   this.$axios.post('http://localhost:8090/产品/listP2',data).then(res => res.data).then(res => res.data).then(res => {
    //     console.log(res)
    //     data.产品名称=res.产品名称
    //     data.单价=res.单价
    //     data.单位=res.单位
    //     console.log(data)
    //   })
    // },
    beforeMount() {
      //this.loadGet();
      //this.loadPost();
    }
}
</script>

<style>
</style>