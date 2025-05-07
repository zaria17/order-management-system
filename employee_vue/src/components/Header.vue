<template>

  <div class="toolbar" style="display: flex;">

    <div style="flex:1;text-align: center;font-size: 34px;">
      <span>欢迎来到系统！</span>
    </div>
    <el-dropdown>
      <i class="el-icon-s-custom" style="margin-right: 8px; margin-top: 1px;font-size: 20px;"></i>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
          <el-dropdown-item @click.native="toManager">雇员管理</el-dropdown-item>
          <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
    <span>{{ user.姓氏+user.名字 }}</span>
  </div>
</template>

<script>
export default{
  data(){
    return {
      user : JSON.parse(sessionStorage.getItem('CurUser'))
    }},
  methods:{
    toUser(){
      console.log('to_user')
      this.$router.push("/Home")
    },
    logout(){
      this.$router.push("/")
    },
    toManager(){
      this.$router.push("/Login2")
    },
  },
  created() {
    this.$router.push("/Home")
  }
}
</script>

<style scoped>

</style>