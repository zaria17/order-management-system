<template>
    <div style="text-align: center;background-color: #f1f1f3;height: 100%;padding: 0px;margin: 0px;">
        <h1 style="font-size: 50px;">{{'欢迎你！'+user.联系人姓名}}</h1>
        <el-descriptions  title="个人中心" :column="2" size="40" border>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-s-custom"></i>
                  联系人姓名
                </template>
                {{user.联系人姓名}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    电话
                </template>
                {{user.电话}}
            </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-s-custom"></i>
              联系人职务
            </template>
            {{user.联系人职务}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-mobile-phone"></i>
              公司名称
            </template>
            {{user.公司名称}}
          </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>
                  国家
                </template>
              {{user.国家}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                  城市
                </template>
              {{user.城市 }}
            </el-descriptions-item>
          <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            地区
          </template>
          {{user.地区}}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-tickets"></i>
              地址
            </template>
            {{user.地址 }}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-s-custom"></i>
              邮政编码
            </template>
            {{user.邮政编码}}
          </el-descriptions-item>
        </el-descriptions>

      <el-button :plain="true" type="primary" style="margin-left: 5px;margin-top: 10px;" @click="mod">编辑</el-button>
      <el-dialog
          title="提示"
          :visible.sync="centerDialogVisible"
          width="30%"
          center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="公司名称" >
            <el-input v-model="form.公司名称"></el-input>
          </el-form-item>
          <el-form-item label="联系人姓名" >
            <el-input v-model="form.联系人姓名"></el-input>
          </el-form-item>
          <el-form-item label="联系人职务" >
            <el-input v-model="form.联系人职务"></el-input>
          </el-form-item>
          <el-form-item label="地址" >
            <el-input v-model="form.地址"></el-input>
          </el-form-item>
          <el-form-item label="城市" >
            <el-input v-model="form.城市"></el-input>
          </el-form-item>
          <el-form-item label="地区" >
            <el-input v-model="form.地区"></el-input>
          </el-form-item>
          <el-form-item label="邮政编码" >
            <el-input v-model="form.邮政编码"></el-input>
          </el-form-item>
          <el-form-item label="国家" >
            <el-input v-model="form.国家"></el-input>
          </el-form-item>
          <el-form-item label="电话" >
            <el-input v-model="form.电话"></el-input>
          </el-form-item>
          <el-form-item label="密码" >
            <el-input v-model="form.密码"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false" >取 消</el-button>
    <el-button type="primary" @click="save">确 定</el-button>
  </span>
      </el-dialog>

        <DateUtils></DateUtils>
    </div>
</template>

<script>
    import DateUtils from "./DateUtils";
    export default {
        name: "Home",
        components: {DateUtils},
        data() {

            return {
              user:{},
              tableData:[],
              centerDialogVisible:false,
              供应商id: '',
              form:{
                供应商id:'',
                公司名称:'',
                联系人姓名:'',
                国家:'',
                联系人职务:'',
                地区:'',
                电话:'',
                城市:'',
                地址:'',
                邮政编码:'',
                密码:'',
              }
            }
        },
        computed:{

        },
        methods:{
          mod() {
            console.log(222)
            this.centerDialogVisible = true;
           console.log(this.user.供应商id)
            this.$axios.post('http://localhost:8090/供应商/listP2', {
                  "供应商id":this.user.供应商id
                }
            ).then(res => res.data).then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
              console.log(this.tableData)
              this.form.供应商id = this.tableData[0].供应商id
              this.form.公司名称 = this.tableData[0].公司名称
              this.form.联系人姓名 = this.tableData[0].联系人姓名
              this.form.联系人职务 = this.tableData[0].联系人职务
              this.form.国家 = this.tableData[0].国家
              this.form.地区 = this.tableData[0].地区
              this.form.城市 = this.tableData[0].城市
              this.form.地址 = this.tableData[0].地址
              this.form.邮政编码 = this.tableData[0].邮政编码
              this.form.电话 = this.tableData[0].电话
              this.form.密码 = this.tableData[0].密码
              console.log(this.form)
            })
            //赋值到表单
          },
          resetForm() {
            this.$refs.form.resetFields();
          },
          save(){
            this.$axios.post('http://localhost:8090/供应商/mod', this.form).then(res => res.data).then(res => {
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
          loadPost() {
            this.$axios.post('http://localhost:8090/供应商/listP2', {
                  "供应商id":this.user.供应商id
                }
            ).then(res => res.data).then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
              console.log(this.tableData)
            })
          },
          loadGet() {
            this.$axios.get('http://localhost:8090/供应商/list').then(res => res.data).then(res => {
              console.log(res)
              this.tableData = res
            })
          },
            init(){
                this.user = JSON.parse(sessionStorage.getItem('CurUser'))
            }
        },
        created(){
            this.init()
        }
    }
</script>

<style scoped>
    .el-descriptions{
        width:90%;

        margin: 0 auto;
        text-align: center;
    }
</style>