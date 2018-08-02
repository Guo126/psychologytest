<template >
    
       <div class="app-container" >
            &nbsp;&nbsp;&nbsp;
        <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>
        &nbsp;&nbsp;&nbsp;
        <el-button type="primary" icon="el-icon-search">搜索</el-button> 
        <div style="float:right">
        <el-button type="primary" icon="el-icon-plus"  @click="addPaper()">添加</el-button> 
        
        </div>
        </br></br></br>
         <el-card  v-for="(o,index) in list" :key="o.responseId" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
        <div style="padding: 14px;">
             <span>第{{o.responseId}}份报告</span>&nbsp;&nbsp;&nbsp;
             <span>最低分数为 <el-input v-model="o.minScore"  style="width:50px"> </el-input>分</span>
             <el-button type="primary"  @click="addPaper()" style="float:right">保存</el-button> 
            </br></br>
            <el-upload
                action="https://jsonplaceholder.typicode.com/posts/"
                list-type="picture-card"
                :http-request="imgRoad"
                :on-preview="handlePictureCardPreview"
                :on-remove="handleRemove">
                <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="imgVisible">
                <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog> </br></br>
            
          <el-input   type="textarea" :rows="8"    v-model="o.responseDesc" > </el-input>
          
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
                list:[],
                dialogImageUrl: '',
                imgVisible: false
          }
           
        },

        created(){
            this.testId = urls.parse().hash['testId'];
            this.getResponse();
        },

        methods:{
          imgRoad(){
              this.$ref.yourprop.file
          },
            getResponse(){
                getRes(this.testId).then(response=>{
                    let data = response.data;
                    this.list = data; 
                   
                })
            },
            handleRemove(file, fileList) {
              console.log(file, fileList);
            },
            handlePictureCardPreview(file) {
              this.dialogImageUrl = file.url;
              this.dialogVisible = true;
            }
       
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



