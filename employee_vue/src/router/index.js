
import VueRouter from 'vue-router';

const routes = [
    {
        path:'/',
        name:'login',
        component:()=>import('../components/Login')
    }
    ,
    {
        path: '/Index',
        name: 'index',
        component: () => import('../components/Index'),

        children:[
            {
                path:'/Home',
                name:'home',
                meta:{
                    title:'首页'
                },
                component:()=>import('../components/Home')
            },
            {
                path:'/产品list',
                name:'产品list',
                meta:{
                    title:'管理员管理'
                },
                component:()=>import('../components/Main.vue')
            },
            {
                path:'/Order',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/Order.vue')
            },
            {
                path:'/OrderDetails',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/OrderDetails.vue')
            },
            {
                path:'/GetOrder',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/GetOrder.vue')
            },
            {
                path:'/CustomerRegion',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/CustomerRegion.vue')
            },
            {
                path:'/RegionSeason',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/RegionalSeason.vue')
            },
            {
                path:'/ItemSupplier',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/ItemSupplier.vue')
            },
            {
                path:'/SuppliersProductTotalMoney',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/SupplierProductTotalMoney.vue')
            },
            {
                path:'/EmployeeOrders',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/EmployeeOrders.vue')
            },
            {
                path:'/CustomerCtr',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/CustomerCtr.vue')
            },
            {
                path:'/SupplierCtrl',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/SupplierCtrl.vue')
            },
            {
                path:'/Login2',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/Login2.vue')
            },
            {
                path:'/EmployeeCtrl',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/EmployeeCtrl.vue')
            },
            {
                path:'/Answer',
                name:'图表',
                meta:{
                    title:'用户管理'
                },
                component:()=>import('../components/Answer.vue')
            },
        ]
    }
]

const router = new VueRouter({
    mode:'history',
    routes
})

// export function resetRouter() {
//     router.matcher = new VueRouter({
//         mode:'history',
//         routes: []
//     }).matcher
// }
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
}
export  default router;