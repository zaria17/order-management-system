import Vue from 'vue';
import App from './App.vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import axios from "axios";
Vue.config.productionTip=false
Vue.prototype.$axios=axios;
import VueRouter from 'vue-router';
import router from "@/router";
Vue.use(ElementUI);
Vue.use(VueRouter);

new Vue({
  router,
  el: '#app',
  render: h => h(App)
})