<template xmlns:el-col="http://www.w3.org/1999/html">
  <el-scrollbar>
    <div>
      <div style="margin-bottom:5px ;margin-top: 5px;margin-left: 5px">
        <el-input v-model="产品名称" placeholder="请输入产品名称：" suffix-icon="el-icon-search" style="width: 200px"></el-input>
        <el-select v-model="类别id" filterable placeholder="请选择类别" style="margin-left: 5px">
          <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
        <el-button type="primary" style="margin-left: 5px" @click="loadPost">查询</el-button>
        <el-button type="primary" @click="add">新增</el-button>
        <el-button :plain="true" type="primary" style="margin-left: 5px" @click="open1">查看当前时间</el-button>
        <img :src="imageSrc" alt="Image" />
      </div>
      <el-table :data="tableData">
        <el-table-column prop="产品id" label="产品ID" width="100" />
        <el-table-column prop="产品名称" label="产品名称" width="140" />
        <el-table-column prop="单位数量" label="单位数量" width="120"/>
        <el-table-column prop="单价" label="单价" width="100" />
        <el-table-column prop="库存量" label="库存量" width="100" />
        <el-table-column prop="中止" label="中止" width="100" >
          <template slot-scope="scope">
            {{ scope.row.中止 ? '是' : '否' }}
          </template>
        </el-table-column>
        <el-table-column prop="类别id" label="类别id" width="100" />
        <el-table-column prop="供应商id" label="供应商id" width="100" />
        <el-table-column prop="订购量" label="订购量" width="100" />
        <el-table-column prop="再订购量" label="再订购量" />
        <el-table-column prop="operate" label="操作" width="200">

          <template slot-scope="scope">
            <el-button size="small" type="success" @click="mod(scope.row)">编辑</el-button>
            <el-popconfirm
                title="确定删除吗？"
                @confirm="del(scope.row.产品id)"
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


      <el-dialog
          title="提示"
          :visible.sync="centerDialog2Visible"
          width="30%"
          center>
        <el-form ref="form2" :model="form2" label-width="80px">
          <el-form-item label="订单ID" >
            <el-input v-model="form2.订单id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form2" :model="form2" label-width="80px">
          <el-form-item label="订购时间" >
            <el-input v-model="form2.订购时间"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form2" :model="form2" label-width="80px">
          <el-form-item label="货主名称">
            <el-input v-model="form2.货主名称"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialog2Visible = false" >取 消</el-button>
    <el-button type="primary" @click="save2">确 定</el-button>
  </span>
      </el-dialog>

      <el-dialog
          title="提示"
          :visible.sync="centerDialog3Visible"
          width="30%"
          center>
        <el-form ref="form3" :model="form3" label-width="80px">
          <el-form-item label="订单id" >
            <el-input v-model="form3.订单id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form3" :model="form3" label-width="80px">
          <el-form-item label="产品id" >
            <el-input v-model="form3.产品id"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form3" :model="form3" label-width="80px">
          <el-form-item label="数量">
            <el-input v-model="form3.数量"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialog3Visible = false" >取 消</el-button>
    <el-button type="primary" @click="save3">确 定</el-button>
  </span>
      </el-dialog>

    </div>
  </el-scrollbar>
</template>

<script>

export default {
  name: "Main",
  data() {
    return {
      imageSrc: '',
      user : JSON.parse(sessionStorage.getItem('CurUser')),
      tableData: [],
      tableData2:[],
      tableData3:[],
      产品名称: '',
      类别id:'',
      产品id:'',
      orderNumber:'',
      centerDialogVisible: false,
      centerDialog2Visible:false,
      centerDialog3Visible:false,
      form: {
        产品id: '',
        产品名称: '',
        单位数量: '',
        单价: '',
        库存量: '',
        中止: '',
        类别id: '',
        供应商id: '',
        订购量: '',
        再订购量: '',
        rowId: '1'
      },
      form2:{
        订单id:'',
        订购日期:'',
        货主名称:'',
        货主地址:'',
        货主城市:'',
        货主地区:'',
        货主邮政编码:'',
        货主国家:'',
        客户id:'',
        rowId2:'1',
      },
      form3:{
        订单id:'',
        产品id:'',
        数量:'',
        rowId: '1'
      },
      options:[{
        value: '1',
        label: '饮料'
      }, {
        value: '2',
        label: '调味品'
      }, {
        value: '3',
        label: '点心'
      }, {
        value: '4',
        label: '日用品'
      }, {
        value: '5',
        label: '谷类/麦片'
      },{
        value: '6',
        label: '肉/家禽'
      },{
        value: '7',
        label: '特制品'
      },{
        value: '8',
        label: '海鲜'
      },{
        value: null,
        label: '请选择类别'
      }]
    }
  },
  methods: {
    open1() {
      // 获取当前时间的 Date 对象
      const date = new Date();
      // 将 Date 对象格式化为 ISO 8601 格式的字符串
      const isoString = date.toISOString();
      // 提取日期和时间部分
      const dateString = isoString.substring(0, 10);
      const timeString = isoString.substring(11, 19);
      // 将日期和时间部分组合成 SQL Server 支持的日期格式
      const formattedDate = `${dateString} ${timeString}`;
      this.$message({
        showClose: true,
        message: formattedDate
      });
    },
    addOrder(){
      this.centerDialog2Visible=true;
      this.$nextTick(() => {
        this.resetForm2();
      })
    },
    save2(){
      this.$refs.form2.validate(valid => {
        if (valid) {
          this.form2.雇员id=this.user.雇员id;
          if (this.form2.订单id) {
            console.log(222)
            console.log(this.form2)
            this.doMod2();
          } else {
            console.log(111)
            this.doSave2();
          }
        } else {
          console.log('error submit!!!');
          return false;
        }
      });
    },
    save3(){
      this.$refs.form3.validate(valid => {
        if (valid) {
          //this.form3.产品id=this.row.产品id;//赋值
          if (this.form3.订单id) {
            console.log(222)
            console.log(this.form2)
            this.doMod3();
          } else {
            console.log(111)
            this.doSave2();
          }
        } else {
          console.log('error submit!!!');
          return false;
        }
      });
    },
    doMod2(){
      this.$axios.post('http://localhost:8090/订单/saveOrMod', this.form2).then(res => res.data).then(res => {
        console.log(res)
        this.tableData2 = res
        if (res.code = 200) {
          //alert('suc')
          this.$message({
            message: '操作成功！',
            type: 'success'
          });
          this.centerDialog2Visible = false
          this.resetForm2()
        } else {
          this.$message({
            message: '操作失败！',
            type: 'error'
          });
        }
      })
    },
    doMod3(){
      this.$axios.post('http://localhost:8090/订单明细/save', this.form3).then(res => res.data).then(res => {
        console.log(res)
        this.tableData3 = res
        if (res.code = 200) {
          //alert('suc')
          this.$message({
            message: '操作成功！',
            type: 'success'
          });
          this.centerDialog3Visible = false
          this.resetForm3()
        } else {
          this.$message({
            message: '操作失败！',
            type: 'error'
          });
        }
      })
    },
    doSave2(){

    },
    resetForm() {
      this.$refs.form.resetFields();
    },
    resetForm2() {
      this.$refs.form2.resetFields();
    },
    resetForm3() {
      this.$refs.form3.resetFields();
    },
    del(产品id) {
      console.log(产品id)
      this.$axios.get('http://localhost:8090/产品/delete?产品id='+产品id).then(res => res.data).then(res => {
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
        this.form.产品id = row.产品id
        this.form.产品名称 = row.产品名称
        this.form.单位数量 = row.单位数量
        this.form.单价 = row.单价
        this.form.库存量 = row.库存量
        this.form.中止 = row.中止
        this.form.类别id = row.类别id
        this.form.供应商id = row.供应商id
        this.form.库存量 = row.库存量
        this.form.订购量 = row.订购量
        this.form.再订购量 = row.再订购量
        this.form.rowId = row.rowId
      })
    },
    addToOrder(row){
      this.centerDialog3Visible = true;
      this.$nextTick(() => {
        //赋值到表单
        this.form3.产品id = row.产品id
        this.form3.rowId = row.rowId
      })
    },
    add() {
      this.centerDialogVisible = true;
      this.$nextTick(() => {
        this.resetForm();
      })
    },
    doSave() {
      this.$axios.post('http://localhost:8090/产品/save', this.form).then(res => res.data).then(res => {
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
      this.$axios.post('http://localhost:8090/产品/saveOrMod', this.form).then(res => res.data).then(res => {
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
          if (this.form.产品id) {
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
      this.$axios.get('http://localhost:8090/产品/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData = res
      })
    },
    loadGet2() {
      this.$axios.get('http://localhost:8090/订单/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData2 = res
      })
    },
    loadGet3() {
      this.$axios.get('http://localhost:8090/订单明细/list').then(res => res.data).then(res => {
        console.log(res)
        this.tableData3 = res
      })
    },
    loadPost() {
      this.$axios.post('http://localhost:8090/产品/listP', {
            "产品名称": this.产品名称,
            "类别id":this.类别id
          }
      ).then(res => res.data).then(res => res.data).then(res => {
        console.log(232)
        if (this.类别id>0){
          this.putimg();
        }
        console.log(res)
        this.tableData = res
      })
    },
    putimg(){
      this.$axios.post('http://localhost:8090/类别/getimage',{
            "类别id":this.类别id
          }
      ).then(res => res.data).then(res => {
        console.log(222)
        const base64Data =res
        this.imageSrc = base64Data
        console.log(this.imageSrc)
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