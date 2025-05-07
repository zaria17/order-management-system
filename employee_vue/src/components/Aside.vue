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

      <el-menu-item index="/GetOrder">
        <el-icon><HomeFilled /></el-icon>
        <span>抢单</span>
      </el-menu-item>

      <el-menu-item index="/CustomerRegion">
        <el-icon><HomeFilled /></el-icon>
        <span>客户地区订货量</span>
      </el-menu-item>

      <el-menu-item index="/RegionSeason">
        <el-icon><HomeFilled /></el-icon>
        <span>地区季节运货量</span>
      </el-menu-item>

      <el-menu-item index="/ItemSupplier">
        <el-icon><HomeFilled /></el-icon>
        <span>不同供应商供货量</span>
      </el-menu-item>


      <el-menu-item index="/SuppliersProductTotalMoney">
        <el-icon><HomeFilled /></el-icon>
        <span>供应产品单价总金额</span>
      </el-menu-item>

      <el-menu-item index="/EmployeeOrders">
        <el-icon><HomeFilled /></el-icon>
        <span>雇员承接订单数</span>
      </el-menu-item>

      <el-menu-item index="/CustomerCtr">
        <el-icon><HomeFilled /></el-icon>
        <span>客户管理</span>
      </el-menu-item>

      <el-menu-item index="/SupplierCtrl">
        <el-icon><HomeFilled /></el-icon>
        <span>供应商管理</span>
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