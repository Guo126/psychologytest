<template>
  <el-scrollbar wrapClass="scrollbar-wrapper">
    <el-menu
      mode="vertical"
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
    >
      <sidebar-item :routes="routes" ></sidebar-item>
      <!-- <sidebar-item :routes="adminRoutes"></sidebar-item> -->
    </el-menu>
  </el-scrollbar>
</template>

<script>
import { mapGetters } from 'vuex'
import SidebarItem from './SidebarItem'

import Cookie from 'js-cookie'

export default {
  
  components: { SidebarItem },
  computed: {
    ...mapGetters([
      'sidebar'
    ]),
    data(){
        return {
            userLevel: 0 ,
        }
    },
    routes() {
      if(this.userLevel==2){
        return this.$router.options.routes
      }else{
        return this.$router.options.routes.slice(0,5)
      }
      
      
    },
   
    isCollapse() {
      return !this.sidebar.opened
    }
  },
  
  created(){
     this.userLevel = Cookie.get("userLevel")
    
  },
  
  
}
</script>
