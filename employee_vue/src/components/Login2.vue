<template>
  <div class="loginBody">
    <div class="loginDiv">
      <div class="login-content">
        <h1 class="login-title">管理员登录</h1>
        <el-form :model="loginForm" label-width="100px"
                 :rules="rules" ref="loginForm">
          <el-form-item label="管理员密码" prop="密码">
            <el-input style="width: 200px" type="password" v-model="密码"
                      show-password autocomplete="off" size="small" @keyup.enter.native="confirm"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="confirm" :disabled="confirm_disabled">确 定</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  name: "Login",
  data(){
    return{
      confirm_disabled:false,
      密码:'',
      rules:{
        密码: [
          { required: true, message: '请输密码', trigger: 'blur' }
        ],
      }
    }
  },
  methods:{

    confirm(){
      if(this.密码==='123'){
        this.$router.replace('/EmployeeCtrl');
      }else{
        this.confirm_disabled=false;
        alert('管理员密码错误！');
        return false;
      }
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
  margin-left: -200px;
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