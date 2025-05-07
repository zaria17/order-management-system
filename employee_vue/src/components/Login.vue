<template>
    <div class="loginBody">
        <div class="loginDiv">
            <div class="login-content">
                <h1 class="login-title">用户登录</h1>
                <el-form :model="loginForm" label-width="100px"
                         :rules="rules" ref="loginForm">
                    <el-form-item label="账号" prop="雇员id">
                        <el-input style="width: 200px" type="text" v-model="loginForm.雇员id"
                                  autocomplete="off" size="small"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="密码">
                        <el-input style="width: 200px" type="password" v-model="loginForm.密码"
                                  show-password autocomplete="off" size="small" @keyup.enter.native="confirm"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="confirm" :disabled="confirm_disabled">确 定</el-button>
                      <el-button type="primary" style="margin-left: 30px" @click="regis">注册</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>

      <el-dialog
          title="提示"
          :visible.sync="centerDialogVisible"
          width="30%"
          center>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="姓氏" >
            <el-input v-model="form.姓氏"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="名字">
            <el-input v-model="form.名字"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="职务">
            <el-input v-model="form.职务"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="尊称">
            <el-input v-model="form.尊称"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="出生日期">
            <el-input v-model="form.出生日期"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="雇用日期">
            <el-input v-model="form.雇用日期"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="地址">
            <el-input v-model="form.地址"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="城市">
            <el-input v-model="form.城市"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="地区">
            <el-input v-model="form.地区"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="邮政编码">
            <el-input v-model="form.邮政编码"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="国家">
            <el-input v-model="form.国家"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="家庭电话">
            <el-input v-model="form.家庭电话"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="备注">
            <el-input v-model="form.备注"></el-input>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="密码">
            <el-input v-model="form.密码"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false" >取 消</el-button>
    <el-button type="primary" @click="save">确 定</el-button>
  </span>
      </el-dialog>
    </div>
</template>


<script>
    export default {
        name: "Login",
        data(){
            return{
                confirm_disabled:false,
                loginForm:{
                    雇员id:'',
                    密码:''
                },
                rules:{
                    雇员id: [
                        { required: true, message: '请输入雇员id', trigger: 'blur' }
                    ],
                    密码: [
                        { required: true, message: '请输密码', trigger: 'blur' }
                    ],
                },
              centerDialogVisible:false,
              tableData:[],
              form:{
                  雇员id:'',
                姓氏:'',
                名字:'',
                职务:'',
                尊称:'',
                出生日期:'',
                雇用日期:'',
                地址:'',
                城市:'',
                地区:'',
                邮政编码:'',
                国家:'',
                家庭电话:'',
                备注:'',
                密码:'',
              }
            }
        },
        methods:{
            regis(){
              this.centerDialogVisible=true;
            },
          save(){
            this.$refs.form.validate(valid => {
              if (valid) {
                if (this.form.姓氏) {
                  console.log(222)
                  console.log(this.form)
                  this.doSave();
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
          doSave(){
            this.$axios.post('http://localhost:8090/雇员/save', this.form).then(res => res.data).then(res => {
              console.log(333)
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
            confirm(){
                this.confirm_disabled=true;
                this.$refs.loginForm.validate((valid) => {
                    if (valid) { //valid成功为true，失败为false
                        //去后台验证用户名密码
                        this.$axios.post('http://localhost:8090/雇员/login',this.loginForm).then(res=>res.data).then(res=>{
                            console.log(res)
                            if(res.code==200){
                                //存储
                                sessionStorage.setItem("CurUser",JSON.stringify(res.data))

                                // console.log(res.data.menu)
                                // this.$store.commit("setMenu",res.data.menu)
                                //跳转到主页
                                this.$router.replace('/Index');
                            }else{
                                this.confirm_disabled=false;
                                alert('校验失败，用户名或密码错误！');
                                return false;
                            }
                        });
                    } else {
                        this.confirm_disabled=false;
                        console.log('校验失败');
                        return false;
                    }
                });

            }
        }
    }
</script>

<style scoped>
    .loginBody {
        position: absolute;
        width: 100%;
        height: 100%;
        background-color: #B3C0D1;
    }
    .loginDiv {
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -250px;
        width: 450px;
        height: 330px;
        background: #fff;
        border-radius: 5%;

    }
    .login-title {
        margin: 20px 0;
        text-align: center;
    }
    .login-content {
        width: 400px;
        height: 250px;
        position: absolute;
        top: 25px;
        left: 25px;
    }
</style>