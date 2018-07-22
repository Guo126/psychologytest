<template>
  <div class="app-container">
    
    <el-card class="box-card1 " style="background-color:#A9D0F5">
      
      <div  class="text item " style="float:left">
        
        &nbsp;欢迎您，
        <el-tag>{{username}}</el-tag>
        </br></br></br>
           &nbsp;选择下方的磁块查看你当前评测进度
      </div>

      <div style="float:right;">
        <img style="height:190px;width:300px;margin-top:-15px;margin-right:-19px;" src="646.png" >
      </div>
      
        
    </el-card>
    </br>
    </br>
    
     <el-card class="box-card2" style="background-color:#424242 ;float:left">
      
      <div class="text" style="color: white">
        <!-- <img src="" class="image" style="float:left"> -->
        <span class = "el-icon-message"> &nbsp;&nbsp;<el-tag >{{mail}}</el-tag>  </span>
        </br></br>
        <span class = "el-icon-phone"> &nbsp;&nbsp;<el-tag >{{phone}}</el-tag>  </span>
        
      </div>
     </el-card>
     <el-card class="box-card2" style="background-color:#0080FF ;float:right">
      <div class="text" style="color:white">
        已完成评测
        </br>
        </br></br>
        <el-progress :text-inside="true" :stroke-width="18"  :percentage="60" color="#01DF3A">
        </el-progress>
        </br></br>
        <el-button style="float: left; padding: 3px 0" type="text ;color:white" @click="toReport">查看报告</el-button>
        
      </div>
      
     </el-card>
    
    
     <el-card class="box-card3" style="background-color:#FA5858 ; float:left ">  
       <el-progress type="circle" :percentage="40" status="success" style=" float:left"></el-progress>
      <div class="text"  style="color:white ;float:right; margin-right:40px ">
        已完成评测
        </br></br></br>
         &nbsp; &nbsp; &nbsp;40%
         </br></br></br>
        <el-button style="float: left; padding: 3px 0 ;color:white" type="text" @click="toTest">开始测评</el-button>

      </div>
     </el-card>
     <el-card class="box-card3" style="background-color:#FFBF00; float:left">
      <el-progress type="circle" :percentage="60" status="exception" style=" float:left"></el-progress>
      
      <div class="text"  style="color:white ;float:right; margin-right:40px ">
          未完成评测 
         </br></br></br>
         &nbsp; &nbsp; &nbsp;60%
         </br></br></br>
        <el-button style="float: left; padding: 3px 0 ;color:white" type="text" @click="toTest">开始测评</el-button>
  
      </div>
     </el-card>
    
        
    <el-card class="box-card2" style="background-color:#2ECCFA ;float:right">
      <div class="text" style="color:white">
        待完成评测
        </br>
        </br></br>
        <el-progress :text-inside="true" :stroke-width="18" :percentage="40" color="#FF0040">
        </el-progress>
        </br></br>
        <el-button style="float: left; padding: 3px 0 ;color:white" type="text" @click="toTest">开始测评</el-button>
        
      </div>
      
     </el-card>
  
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
import Cookie from 'js-cookie'

export default {
  data() {
    return {
      userId:undefined,
      list: null,
      listLoading: true,
      username:'',
      mail:'',
      phone:'',
      
      
      
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
    this.userId = Cookie.get("userId");
    this.username = Cookie.get("userName");
    this.phone = Cookie.get("userPhone");
    this.mail = Cookie.get("userPhone");
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
       
        this.list = response.data.items;
        this.listLoading = false
       
      
      })
    },
    toReport(){
      this.$router.push("/example/report");
    },
    toTest(){
      this.$router.push("/example/test")
    }
    

  }
}
</script>