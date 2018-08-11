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
        <el-button @click="deleteButton(scope.row.userId);dialogVisible=true" type="text" size="middle">删除</el-button>
          
      </template>
    </el-table-column>
  </el-table>
    <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="20%"
            :before-close="handleClose">
            <span>确认删除吗？</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary"  @click="dialogVisible =false ;deleteUser()">确 定</el-button>
            </span>
          </el-dialog>
  </div>
</template>

<script>
import {userSearch,userDelete} from "@/api/login"

  export default {
    created(){
      this.search()
    },
    methods:{ 
      
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      deleteButton(id){
        this.id = id ;
      },
      deleteUser(){
        userDelete(this.id).then(response=>{
          if(response.success){
            this.$message.success('删除成功！');
            location.reload()
          }else{
            this.$message.error('删除失败！');
           
          }
        })
      },
      search(){
        userSearch(this.input).then(response=>{
          if(response.success){
            
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
        dialogVisible:false,
        id:0,
      }
    }
  }
</script>
