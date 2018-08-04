import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/example',
    name: '心理测试',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },

  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: '心理测试', icon: 'example' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/table/index'),
        meta: { title: '基本概况', icon: 'table' }
      },
      {
        path: 'test',
        name: 'Test',
        component: () => import('@/views/test/index'),
        meta: { title: '开始测试', icon: 'eye' },
        
      },
     
      {
        path: 'testing',
        name: 'Testing',
        component: () => import('@/views/test/test'),
        meta: { title: '正在测试' },
        hidden:true
      },
      {
        path: 'report',
        name: 'Report',
        component: () => import('@/views/report/index'),
        meta: { title: '查看报告', icon: 'table' }
      },
      {
        path: 'details',
        name: 'Details',
        component: () => import('@/views/report/details'),
        meta: { title: '报告详情' },
        hidden:true
      },
    ]
  },

  {
    path: '/form',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Form',
        component: () => import('@/views/form/index'),
        meta: { title: '个人信息', icon: 'form' }
      }
    ]
  },

  {
    path: '/admin',
    component:Layout,  
    meta: { title: '管理员', icon: 'example' },  
    children:[
      {
        path: 'userMes',
        name: 'Usermes',
        
        component: () => import('@/views/admin/userMes'),
        meta: { title: '用户管理', icon: 'example' },
        
      },
      {
        path: 'papers',
        name: 'Papers',     
        component: () => import('@/views/admin/papers'),
        meta: { title: '试题管理', icon: 'example' },
        
      },
     
      
      {
        path: 'changequestion',
        name: 'changeq',     
        component: () => import('@/views/admin/changequestion'),
        meta: { title: '修改题目', icon: 'example' },
        hidden :true
      },
      
      {
        path: 'changeresponse',
        name: 'changer',     
        component: () => import('@/views/admin/changeresponse'),
        meta: { title: '修改报告', icon: 'example' },
        hidden :true
      },
      
     
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

