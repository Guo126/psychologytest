<template>

 <div class="app-container">
     <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>
     &nbsp;&nbsp;&nbsp;
     <el-button type="primary" icon="el-icon-search">搜索</el-button> 
     </br></br></br>
  <el-table 
    :data="tableData"
    border
    style="width: 100%">
    
    <el-table-column
      prop="name"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      
      prop="date"
      label="出生日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别"
      width="120">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="联系电话"
      width="140">
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
        <el-button @click="handleClick(scope.row)" type="text" size="small">删除</el-button>
        
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>

<script>
  export default {
    methods: {
      handleClick(row) {
        console.log(row);
      },
     
    },

    data() {
      return {
        tableData: [{
          date: '2016-05-03',
          name: '网市场',
          sex: '男',
          phone:'12563521254',
          mail:'1846545214@qq.com',
         
          
        }],
       input:'',
      }
    }
  }
</script>
