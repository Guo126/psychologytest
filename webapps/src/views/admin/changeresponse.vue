<template >  
       <div class="app-container" > &nbsp;&nbsp;&nbsp; 
        <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>&nbsp;&nbsp;&nbsp;    
        <el-button type="primary" icon="el-icon-search">搜索</el-button> 
        <div style="float:right">
        <el-button type="primary" icon="el-icon-plus"  @click="dialogFormVisible=true">添加</el-button> 
        <el-dialog title="添加报告" :visible.sync="dialogFormVisible">
          <el-form >
            <el-form-item label="最低分数" label-width="80px">
              <el-input v-model="addScore" auto-complete="off" style="width:80px"></el-input>&nbsp;&nbsp;分
            </el-form-item>
            <el-form-item label="报告内容" label-width="80px">
              <el-input v-model="addDesc" auto-complete="off" type="textarea" :rows="8"></el-input>
            </el-form-item> 
                  </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogFormVisible = false; addResponse()">确 定</el-button>
          </div>
        </el-dialog>
        </div>
        </br></br></br>
         <el-card  v-for="(o,index) in list" :key="o.responseId" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
        <div style="padding: 14px;">
             <!-- <span>第{{o.responseId}}份报告</span>&nbsp;&nbsp;&nbsp; -->
             <span>最低分数为 <el-input v-model="o.minScore"  style="width:50px"> </el-input>分</span>
             <el-button type="primary"  @click="resetResponse(o.responseId,o.responseDesc)" style="float:right">保存</el-button> &nbsp; &nbsp;
             <el-button type="primary"  @click="deleteButton(o.responseId);dialogVisible = true" style="float:right">删除</el-button>  &nbsp; &nbsp;
             <el-dialog
              title="提示"
              :visible.sync="dialogVisible"
              width="20%"
              :before-close="handleClose">
              <span>确认删除吗？</span>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary"  @click="dialogVisible =false ;deleteResponse()">确 定</el-button>
              </span>
            </el-dialog>
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
import {addRes} from "@/api/change"; 
import {deleteRes} from "@/api/change"; 
import {resetRes} from "@/api/change"; 
import urls from "urls-js";


    export default{
        data(){
            return{
                testId:undefined,
                num : 1 ,                         
                loading:true,               
                list:[],
                dialogImageUrl: '',
                imgVisible: false,
                dialogVisible :false,
                index: -1,
                dialogFormVisible: false ,
                name:'',
                width:'300px',
                addScore: 0,
                addDesc:'',
          }
           
        },

        created(){
            this.testId = urls.parse().hash['testId'];
            this.getResponse();
        },

        methods:{

          deleteButton(resid){
        
            this.index = resid
            
          },
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
            },
            resetResponse(id,desc){
              resetRes(id,desc).then(response=>{
                  if(response.success){                     
                      alert("修改成功！")
                      location.reload()
                    }else{
                      alert("修改失败！")
                    }
                              
                     })
            },  
            deleteResponse(){
              deleteRes(this.index).then(response=>{
                if(response.success){                     
                      alert("删除成功！")
                      location.reload()
                    }else{
                      alert("删除失败！")
                    }
              })
            },
            addResponse(){
              addRes(this.addDesc,this.testId,this.addScore).then(response=>{
                if(response.success){
                    alert("添加成功！")
                    location.reload()
                }else{
                    alert("添加失败！")
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



