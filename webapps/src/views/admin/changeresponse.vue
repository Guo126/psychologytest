<template>  
       <div class="app-container" > &nbsp;&nbsp;&nbsp;        
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
        </div> </br></br></br>
        <el-card  v-for="(o,index) in list" :key="o.responseId" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px" method="getImgList(o.responseId)">
           
          <div style="padding: 14px;">
             <span>报告ID:&nbsp;&nbsp;{{o.responseId}}</span>&nbsp;&nbsp;&nbsp;
             <span>最低分数为 <el-input v-model="o.minScore"  style="width:50px"> </el-input>分</span>
             <el-button type="primary"  @click="resetResponse(o.responseId,o.minScore,o.responseDesc)" style="float:right">保存</el-button> &nbsp; &nbsp;
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
            </el-dialog></br></br>
            <el-button type="primary"  @click="deleteButton(o.responseId);getImgList(o.responseId) ;uploadVisible = true" >图片上传</el-button>  &nbsp; &nbsp;
            <el-dialog
                z-index = 2
                title="图片上传"
                :visible.sync="uploadVisible"
                width="60%"
                size="large"
                :before-close="handleClose">
                  <div v-for="n in  imgList" :key="n.imgId" >
                    <img  width="140px" height="140px" :src="n.imgUrl" style="float:right ;margin-left:20px" @click="imgVisible=true;check(n.imgUrl)" >
                 </div> 
              <div >
                <el-upload                   
                    action="http://101.132.161.199:8848/psycholog/img/"
                    list-type="picture-card"
                    :http-request="imgRoad"                    
                    :show-file-list="false"            
                    :on-preview="handlePictureCardPreview"                  
                    >
                    <i class="el-icon-plus"></i>
                </el-upload>
              </div>
            </br>
                <el-dialog z-index= 10 :visible.sync="imgVisible" append-to-body="true">
                    <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
                <span slot="footer" class="dialog-footer">
                  <el-button @click="uploadVisible = false">取 消</el-button>
                  <el-button type="primary"  @click="uploadVisible =false ">确 定</el-button>
                </span>
            </el-dialog>
           </br></br></br> 

          <el-input   type="textarea" :rows="8"    v-model="o.responseDesc" > </el-input>         
        </div>       
      </el-card>            
    </div>
    
</template>

<script>
import {getRes,addRes,deleteRes,resetRes,saveImg,getImg} from "@/api/change";
import {getResponsePage} from "@/api/test"; 

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
                imgVisible:false,
                dialogImageUrl:'',  
                imgList:[],  
                lists:[] ,
                uploadVisible:false,                     
          }
           
        },

        created(){
            this.testId = urls.parse().hash['testId'];
            this.getResponse();
            
        },

        methods:{
          check(url){
            this.dialogImageUrl=url
          },
          getImgList(resId){
             getImg(resId).then(response=>{
              if(response.success){                                          
                 this.imgList=response.data 
                           
              }
            })
            
          },
          imgRoad(item){
            let img = item.file           
            let newData = new FormData()
            newData.append('responseId', this.index)
            newData.append('img', img)                        
            saveImg(newData).then(response=>{
              if(response.success){
                this.$message.success("上传成功！") 
                 location.reload()
                  
              }
            })
          },
          deleteButton(resid){
        
            this.index = resid
            
          }, 
          getResponse(){
              getRes(this.testId).then(response=>{
                  let data = response.data;
                  this.list = data; 
                  // let i = 0  
                  // for( ;i<data.length;i++){
                  //   this.getImgList(data[i].responseId)
                  // }
                  
              })
          },
         
          handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.imgVisible = true;
          },
          resetResponse(id,min,desc){
            resetRes(id,min,desc).then(response=>{
                if(response.success){                     
                    this.$message.success("修改成功！") 
                    
                  }else{
                    this.$message.error('修改失败！');
                  }
                            
                    })
          },  
          deleteResponse(){
            deleteRes(this.index).then(response=>{
              if(response.success){                     
                    this.$message.success("删除成功！") 
                    location.reload()
                  }else{
                    this.$message.error('删除失败！');
                  }
            })
          },
          addResponse(){
            addRes(this.addDesc,this.testId,this.addScore).then(response=>{
              if(response.success){
                  this.$message.success("添加成功！") 
                  location.reload()
              }else{
                  this.$message.error('添加失败！');
              }
            })
          },
          handleClose(done) {
       this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
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



