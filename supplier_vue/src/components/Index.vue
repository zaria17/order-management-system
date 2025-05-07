<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246);">
      <Aside></Aside>
    </el-aside>


    <el-container style="height: 100%;">
      <el-header style="text-align: right; font-size: 12px">
        <Header></Header>
      </el-header>

      <el-main style="height: 100%;">
<!--        <Main></Main>-->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Aside from "@/components/Aside.vue";
import Header from "@/components/Header.vue"

export default {
  name:'Index',
  components: {Aside,Header}
};
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}
.el-main{
  padding:5px;
}
.el-aside {
  color: #333;
}
</style>