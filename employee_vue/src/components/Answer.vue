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
        <el-table-column prop="operate" label="操作" width="160">
          <template slot-scope="scope">
            <el-button size="small" type="success" @click="ask(scope.row)">回复</el-button>
<!--            <el-button size="small" type="success" @click="mod(scope.row)">编辑</el-button>-->
            <!--            <el-popconfirm-->
            <!--                title="确定删除吗？"-->
            <!--                @confirm="del(scope.row.订单id)"-->
            <!--                style="margin-left: 5px"-->
            <!--            >-->
            <!--              <el-button slot="reference" size="small" type="danger" >删除</el-button>-->
            <!--            </el-popconfirm>-->
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="咨询" :visible.sync="centerDialog2Visible" width="30%" center>
        <el-form ref="form2" :model="form2" label-width="80px">
          <el-form-item label="咨询内容">
            <el-input v-model="form2.咨询内容"></el-input>
          </el-form-item>
        </el-form>
                <el-form ref="form2" :model="form2" label-width="80px">
                  <el-form-item label="回复内容">
                    <el-input v-model="form2.回复内容"></el-input>
                  </el-form-item>
                </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialog2Visible = false" >取 消</el-button>
         <el-button type="primary" @click="save2">确 定</el-button>
        </span>
      </el-dialog>

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
      tableData2: [],
      centerDialog2Visible: false,
      雇员id:'',
      form2:{
        客户id:'',
        雇员id:'',
        咨询时间:'',
        咨询内容:'',
        回复时间:'',
        回复内容:''
      },
    }
  },
  methods: {
    ask(row){
      this.centerDialog2Visible=true;
      this.form2.咨询内容=row.咨询内容
      this.form2.回复内容=row.回复内容
      this.form2.雇员id=row.雇员id
      this.form2.咨询时间=row.咨询时间
      this.form2.回复时间=row.回复时间
      this.form2.客户id=row.客户id
    },
    save2(){
      this.$refs.form2.validate(valid => {
        if (valid) {
          if (this.form2.回复内容) {
            this.form2.雇员id=this.user.雇员id
            console.log(222)
            console.log(this.form2)
            this.doMod2();
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
    doMod2(){
      this.$axios.post('http://localhost:8090/咨询记录/mod', this.form2).then(res => res.data).then(res => {
        console.log(res)
        this.tableData2 = res
        if (res.code = 200) {
          //alert('suc')
          this.$message({
            message: '操作成功！',
            type: 'success'
          });
          this.centerDialog2Visible = false
          //this.loadPost2()
          this.resetForm()
        } else {
          this.$message({
            message: '操作失败！',
            type: 'error'
          });
        }
      })
    },
    loadGet() {
      this.$axios.get('http://localhost:8090/咨询记录/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },

    loadPost() {
      this.$axios.post('http://localhost:8090/咨询记录/listP2', {
            "雇员id":this.user.雇员id
          }
      ).then(res => res.data).then(res => res.data).then(res => {
        console.log(232)
        console.log(res)
        this.tableData = res
      })
    },
    resetForm() {
      this.$refs.form2.resetFields();
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