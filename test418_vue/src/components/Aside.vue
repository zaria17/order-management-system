<template>
  <div>
    <el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        text-color="#fff"
        default-active="/Home"
        style="height: 300vh;"
        router
    >

      <el-menu-item index="/Home">
        <el-icon><HomeFilled /></el-icon>
        <span>个人中心</span>
      </el-menu-item>

      <el-menu-item index="/产品list">
        <el-icon><HomeFilled /></el-icon>
        <span>产品</span>
      </el-menu-item>

      <el-menu-item index="/Order">
        <el-icon><HomeFilled /></el-icon>
        <span>订单</span>
      </el-menu-item>

      <el-menu-item index="/OrderDetails">
        <el-icon><HomeFilled /></el-icon>
        <span>订单明细</span>
      </el-menu-item>

      <el-menu-item index="/Answer">
        <el-icon><HomeFilled /></el-icon>
        <span>售后咨询</span>
      </el-menu-item>

    </el-menu>
  </div>
</template>

<script>
export default{
  name:"Aside",
}

</script>

<style scoped>

</style>