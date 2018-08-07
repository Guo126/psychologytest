<template>

 <div class="app-container">
     <el-input v-model="input" placeholder="请输入姓名" style="float:left;width:400px"></el-input>
     &nbsp;&nbsp;&nbsp;
     <el-button type="primary" icon="el-icon-search" @click="search()">搜索</el-button> 
     </br></br></br>
  <el-table 
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="userId"
      label="用户ID"
      width="100">
    </el-table-column>
    <el-table-column
      prop="nickname"
      label="姓名"
      width="120">
    </el-table-column>  
    <el-table-column
      prop="username"
      label="用户名"
      width="120">
    </el-table-column>
    <el-table-column
      
      prop="birthday"
      label="出生日期"
      width="200">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别"
      width="120">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="联系电话"
      width="150">
    </el-table-column>
    <el-table-column
      prop="mail"
      label="邮箱"
      width="300">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="delete(1)" type="text" size="middle">删除</el-button>
        
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>

<script>
import {userSearch,userDelete} from "@/api/login"

  export default {
    created(){
      this.search()
    },
    methods: {
     
      delete(id){
        userDelete(id).then(response=>{
          if(response.success){
            alert("删除成功!")
            location.reload()
          }else{
            alert("删除失败!")
          }
        })
      },
      search(){
        userSearch(this.input).then(response=>{
          if(response.success){
            console.log(response.data)
              this.tableData=response.data
          }
        })
      },
     
    },

    data() {
      return {
        tableData: [{
         
        }],
        input:'',
      }
    }
  }
</script>
