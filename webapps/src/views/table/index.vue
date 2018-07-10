<template>
  <div class="app-container">
    
    <el-card class="box-card1 ">
      <div  class="text item ">
        <img src="" >
        欢迎您，
        <el-tag>{{name}}</el-tag>
        </br>
        选择下方的磁块查看你当前评测进度
      </div>
    </el-card>
    </br>
    </br>
    
     <el-card class="box-card2" style="background-color:#424242 ;float:left">
      
      <div class="text">
        <img src="152.jpg" class="image" style="float:left">
        <el-tag>{{mail}}</el-tag>
        </br>
        <el-tag>{{phone}}</el-tag>
      </div>
     </el-card>
     <el-card class="box-card2" style="background-color:#0080FF ;float:right">
      <div class="text" style="color:white">
        已完成评测
        </br>
        </br></br>
        <el-progress :text-inside="true" :stroke-width="18" :percentage="70" color="#01DF3A">
        </el-progress>
        </br></br>
        查看报告
      </div>
      
     </el-card>
    
    
     <el-card class="box-card3" style="background-color:#FA5858 ; float:left ">  
       <el-progress type="circle" :percentage="100" status="success" style=" float:left"></el-progress>
      <div class="text"  style="color:white">
      已完成评测
       
      </div>
     </el-card>
     <el-card class="box-card3" style="background-color:#FFBF00; float:left">
      <el-progress type="circle" :percentage="50" status="exception" style=" float:left"></el-progress>
      <div class="text"  style="color:white">
       未完成评测
      </div>
     </el-card>
    
        
    <el-card class="box-card2" style="background-color:#2ECCFA ;float:right">
      <div class="text" style="color:white">
        待完成评测
        </br>
        </br></br>
        <el-progress :text-inside="true" :stroke-width="18" :percentage="30" color="#FF0040">
        </el-progress>
        </br></br>
        查看报告
      </div>
      
     </el-card>

  
   


   <el-table :data="list" v-loading.body="listLoading" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column align="center" label='ID' width="95">
        <template slot-scope="scope">
          {{scope.$index}}
        </template>
      </el-table-column>
      <el-table-column label="Title">
        <template slot-scope="scope">
          {{scope.row.title}}
        </template>
      </el-table-column>
      <el-table-column label="Author" width="110" align="center">
        <template slot-scope="scope">
          <span>{{scope.row.author}}</span>
        </template>
      </el-table-column>
      <el-table-column label="Pageviews" width="110" align="center">
        <template slot-scope="scope">
          {{scope.row.pageviews}}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="Status" width="110" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{scope.row.status}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="Display_time" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span>{{scope.row.display_time}}</span>
        </template>
      </el-table-column>
    </el-table>
    
  </div>
</template>


<style>
  .image{
    width:100px;  height:100px;
    
    display: block;
  

  }
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card1 {
    width: 100%;
    height: 160px;
  }
  .box-card2 {
    width: 50%;
    height:160px;
  }
  .box-card3 {
    width: 25%;
    height:160px;
  }
  .color{
    background-color:rgb(95, 224, 241);
  }
</style>


<script>


import { getList } from '@/api/table'
import { mapGetters } from 'vuex'

export default {
  data() {
    return {
      list: null,
      listLoading: true,
      username:'',
      mes:{
          mail:'',
          phone:'',
      },
      
    }
  },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  created() {
    this.fetchData()
  },
  computed:{

    ...mapGetters([
      'name',
      'roles'
    ])
  },
  methods: {
    fetchData() {
        this.listLoading = true;
        getList(this.listQuery).then(response => {
         
        this.username = response.data.items[0].author;
       
        this.list = response.data.items;
        this.listLoading = false
       
        getMes(this.mes).then(response=>{
           this.mes.mail = response.data.mail;
           this.mes.phone = response.data.phone;

        })
      })
    }
  }
}
</script>