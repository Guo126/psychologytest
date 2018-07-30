<template >
    
       <div class="app-container" >
            &nbsp;&nbsp;&nbsp;
        <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>
        &nbsp;&nbsp;&nbsp;
        <el-button type="primary" icon="el-icon-search">搜索</el-button> 
        <div style="float:right">
        <el-button type="primary" icon="el-icon-plus"  @click="addPaper()">添加</el-button> 
        <el-button type="primary" @click="onSubmit">保存</el-button>
        <el-button @click="onCancel">退出</el-button>
        </div>
        </br></br></br>
         <el-card  v-for="(o,index) in list" :key="o.responseId" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
        <div style="padding: 14px;">
             <span>第{{o.responseId}}份报告</span>&nbsp;&nbsp;&nbsp;
             <span>最低分数为 <el-input v-model="o.scoreMin"  style="width:50px"> </el-input>分</span>
            </br></br>
          <el-input v-model="o.responseDesc" > </el-input>
          
          <div class="bottom clearfix">
            <time class="time">{{ currentDate }}</time>
              
             
          </div>
        </div>
        
      </el-card>
         

        <div class="block" style=" margin-left:36% ; margin-top:100px">
            <span class="demonstration"></span>
            <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="currentPage"
            :page-size="4"
            layout="prev, pager, next, jumper"
            :total="list.length">
            </el-pagination>
        </div>    
        
      
    </div>
    
</template>

<script>
import {getRes} from "@/api/change";

import urls from "urls-js";


    export default{
        data(){
            return{
                testId:undefined,
                num : 1 ,                         
                loading:true,               
                list:[]
          }
           
        },

        created(){
            this.testId = urls.parse().hash['testId'];
            this.getResponse();
        },

        methods:{
            getResponse(){
                getRes(this.testId).then(response=>{
                    let data = response.data;
                    this.list = data;
                    
                    alert(data[0].responseDesc);
                    alert(data[0].scoreMin);
                })
            },

           
            
        }
    }
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
    margin: 0 auto;
    margin-top: 10%;
  }
</style>



