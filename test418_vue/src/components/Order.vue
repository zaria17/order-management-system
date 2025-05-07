<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <!--      查询-->
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
<!--        <el-select v-model="类别id" filterable placeholder="请选择类别" style="margin-left: 5px">-->
<!--          <el-option-->
<!--              v-for="item in options"-->
<!--              :key="item.value"-->
<!--              :label="item.label"-->
<!--              :value="item.value">-->
<!--          </el-option>-->
<!--        </el-select>-->
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询你的订单</el-button>
      </div>
      <el-table :data="tableData">
        <el-table-column prop="订单id" label="订单id" width="70" />
        <el-table-column prop="订购日期" label="订购日期" width="100" />
        <el-table-column prop="发货日期" label="发货日期" width="100"/>
        <el-table-column prop="到货日期" label="到货日期" width="100" />
        <el-table-column prop="货款确认日期" label="货款确认日期" width="100" />
        <el-table-column prop="运货费" label="运货费" width="100" ></el-table-column>
        <el-table-column prop="货主名称" label="货主名称" width="100" />
        <el-table-column prop="货主地址" label="货主地址" width="140" />
        <el-table-column prop="货主城市" label="货主城市" width="100" />
        <el-table-column prop="货主地区" label="货主地区" width="100" />
        <el-table-column prop="客户id" label="客户id" width="100" />
        <el-table-column prop="货款" label="货款" width="100" />
        <el-table-column prop="总金额" label="总金额" />
        <el-table-column prop="operate" label="操作" width="160">
          <template slot-scope="scope">
            <el-button size="small" type="success" @click="mod(scope.row)">编辑</el-button>
            <el-button size="small" type="success" @click="ask(scope.row)">咨询</el-button>
<!--            <el-popconfirm-->
<!--                title="确定删除吗？"-->
<!--                @confirm="del(scope.row.订单id)"-->
<!--                style="margin-left: 5px"-->
<!--            >-->
<!--              <el-button slot="reference" size="small" type="danger">删除</el-button>-->
<!--            </el-popconfirm>"-->
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="提示" :visible.sync="centerDialogVisible" width="30%" center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="货主名称">
            <el-input v-model="form.货主名称"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="货主地址">
            <el-input v-model="form.货主地址"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="货主城市">
            <el-input v-model="form.货主城市"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="货主地区">
            <el-input v-model="form.货主地区"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false" >取 消</el-button>
         <el-button type="primary" @click="save">确 定</el-button>
        </span>
      </el-dialog>

      <el-dialog title="咨询" :visible.sync="centerDialog2Visible" width="30%" center>
        <el-form ref="form2" :model="form2" label-width="80px">
          <el-form-item label="咨询内容">
            <el-input v-model="form2.咨询内容"></el-input>
          </el-form-item>
        </el-form>
<!--        <el-form ref="form2" :model="form2" label-width="80px">-->
<!--          <el-form-item label="回复内容">-->
<!--            <el-input v-model="form2.回复内容"></el-input>-->
<!--          </el-form-item>-->
<!--        </el-form>-->
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
  name: "Order",
  data() {
    return {
      user : JSON.parse(sessionStorage.getItem('CurUser')),
      tableData: [],
      tableData2: [],
      订单id: '',
      客户id:'',
      供应商id:'',
      centerDialogVisible: false,
      centerDialog2Visible: false,
      form: {
        订单id: '',
        订购日期:'',
        发货日期:'',
        到货日期:'',
        货款确认日期:'',
        运货费:'',
        货主名称:'',
        货主地址:'',
        货主城市:'',
        货主地区:'',
        货款:'',
        雇员id:'',
        客户id:'',
        总金额:'',
        rowId: '1'
      },
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
    },
    save2(){
      this.$refs.form2.validate(valid => {
        if (valid) {
          if (this.form2.咨询内容) {
            this.form2.客户id=this.user.客户id
            console.log(222)
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
      this.$axios.post('http://localhost:8090/咨询记录/save', this.form2).then(res => res.data).then(res => {
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
    loadPost2(){

    },
    resetForm() {
      this.$refs.form.resetFields();
    },
    del(订单id) {
      console.log(订单id)
      this.$axios.get('http://localhost:8090/订单/delete?订单id='+订单id).then(res => res.data).then(res => {
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
        this.form.订购日期 = row.订购日期
        this.form.发货日期 = row.发货日期
        this.form.货款确认日期 = row.货款确认日期
        this.form.运货费 = row.运货费
        this.form.货主名称 = row.货主名称
        this.form.货主地址 = row.货主地址
        this.form.货主城市 = row.货主城市
        this.form.货主地区 = row.货主地区
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
      this.$axios.post('http://localhost:8090/订单/save', this.form).then(res => res.data).then(res => {
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
      this.$axios.post('http://localhost:8090/订单/saveOrMod', this.form).then(res => res.data).then(res => {
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
            this.form.客户id=this.user.客户id
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
      this.$axios.get('http://localhost:8090/订单/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },
    loadPost() {
      this.$axios.post('http://localhost:8090/订单/listP2', {
            "客户id": this.user.客户id
          }
      ).then(res => res.data).then(res => res.data).then(res => {
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