<template >
    
       <div class="app-container" >
            &nbsp;&nbsp;&nbsp;
        <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>
     &nbsp;&nbsp;&nbsp;
     <el-button type="primary" icon="el-icon-search">搜索</el-button> 
        <el-button type="primary" icon="el-icon-plus" style="float:right" @click="addPaper()">添加</el-button> 
        </br></br></br>
        <el-card   v-for="o in list" :key="o.questionId" shadow="hover" :body-style="{ padding: '10px'  }" style="background-color:#E0ECF8 ; margin-top:6px" >          
            <span>第{{o.num}}题</span>
            </br></br>
            <el-input    v-loading="loading"  v-model="o.desc">
                &nbsp;&nbsp;&nbsp;&nbsp;{{o.desc}}
            </el-input>
            </br></br>
            <div class="block">             
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
import {getQues} from "@/api/change";
import {getQuestion} from "@/api/test" ;
import urls from "urls-js";
import {getCount} from "@/api/test";

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
            this.testId = urls.parse().hash['testId']
            this.getMaxnum();
            this.getQuestion();
            this.getQuestions();
        },

        methods:{
            getQuestions(){
                getQues(this.testId).then(response=>{
                    let data = response.data;
                    this.list = response.data;
                    alert(data[0].desc);
                })
            },

            getMaxnum(){
                getCount(this.testId).then(response=>{
                    this.maxnum = response.data;
                })
            },

            getQuestion(){
                getQuestion(this.testId,this.num).then(response=>{
                    this.loading = true
                    if(response.success){
                        let data = response.data;
                        this.num=data.num;
                        this.question = data.desc;
                        this.loading = false;
                        
                    }
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



