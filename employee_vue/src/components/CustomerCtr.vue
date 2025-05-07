<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
        <el-input v-model="客户id" placeholder="请输入客户id：" suffix-icon="el-icon-search" style="width: 200px"></el-input>
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询</el-button>
        <el-button type="primary" style="margin-left: 5px" @click="loadGet">查看全部</el-button>
<!--        <el-button type="primary" @click="add">新增</el-button>-->
      </div>
      <el-table :data="tableData">
        <el-table-column prop="客户id" label="客户id" width="100" />
        <el-table-column prop="公司名称" label="公司名称" width="140" />
        <el-table-column prop="联系人姓名" label="联系人姓名" width="120"/>
        <el-table-column prop="联系人职务" label="联系人职务" width="100" />
        <el-table-column prop="地址" label="地址" width="100" />
        <el-table-column prop="城市" label="城市" width="100" />
        <el-table-column prop="地区" label="地区" width="100" />
        <el-table-column prop="邮政编码" label="邮政编码" width="100" />
        <el-table-column prop="电话" label="电话" width="100" />
        <el-table-column prop="传真" label="传真" />
        <el-table-column prop="operate" label="操作" width="200">
          <template slot-scope="scope">
<!--            <el-button size="small" type="success" @click="mod(scope.row)">编辑</el-button>-->
            <el-popconfirm
                title="确定删除吗？"
                @confirm="del(scope.row.客户id)"
                style="margin-left: 5px"
            >
              <el-button slot="reference" size="small" type="danger" >删除</el-button>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog
          title="提示"
          :visible.sync="centerDialogVisible"
          width="30%"
          center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="产品ID" >
            <el-input v-model="form.产品id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="产品名称">
            <el-input v-model="form.产品名称"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="单位数量">
            <el-input v-model="form.单位数量"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="单价">
            <el-input v-model="form.单价"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="库存量">
            <el-input v-model="form.库存量"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="中止">
            <el-input v-model="form.中止" ></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="类别id">
            <el-input v-model="form.类别id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="供应商id">
            <el-input v-model="form.供应商id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="订购量">
            <el-input v-model="form.订购量"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="再订购量">
            <el-input v-model="form.再订购量"></el-input>
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

export default {
  name: "CustomerCtr",
  data() {
    return {
      tableData: [],
      客户id:'',
      orderNumber:'',
      centerDialogVisible: false,
      form: {
        客户id: '',
        公司名称: '',
        联系人姓名: '',
        联系人职务: '',
        地址: '',
        城市: '',
        地区: '',
        邮政编码: '',
        国家: '',
        电话: '',
        传真: '',
        rowId: '1'
      },
    }
  },
  methods: {

    resetForm() {
      this.$refs.form.resetFields();
    },
    del(客户id) {
      console.log(客户id)
      this.$axios.get('http://localhost:8090/客户/delete?客户id='+客户id).then(res => res.data).then(res => {
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
      this.$axios.get('http://localhost:8090/客户/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },

    loadPost() {
      this.$axios.post('http://localhost:8090/客户/listP2', {
            "客户id":this.客户id
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