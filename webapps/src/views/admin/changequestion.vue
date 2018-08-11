<template >
    <div class="app-container" > &nbsp;&nbsp;&nbsp;
        
        <div style="float:right">
          <span>共{{total}}题</span>
            <el-button type="primary" icon="el-icon-plus"  @click="dialogFormVisible = true">添加</el-button> 
            <el-dialog title="添加试题" :visible.sync="dialogFormVisible">
                <el-form >
                  <el-form-item label="试题内容" label-width="80px">
                    <el-input type="textarea" v-model="addDesc" auto-complete="off" :rows="5"></el-input>
                  </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                  <el-button @click="dialogFormVisible = false">取 消</el-button>
                  <el-button type="primary" @click="dialogFormVisible = false ; addQuestion()" >确 定</el-button>
                </div>
            </el-dialog>
        </div>
        </br></br></br>
         <el-card  v-for="(o,index) in list" :key="o.questionNum" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px">
          <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
          <div style="padding: 14px;">
              <span>第{{currentPage}}页&nbsp;&nbsp;第{{index+1}}题</span>&nbsp;&nbsp;&nbsp;
              </br></br>
              <el-input   type="textarea" :rows="3"    v-model="o.questionDesc" > </el-input>    
              <el-button type="primary"  @click="resetQuestion(o.questionNum,o.questionDesc)" style="float:right">保存</el-button> &nbsp; &nbsp;
              <el-button type="primary"  @click="dialogVisible = true;deleteButton(o.questionNum)" style="float:right">删除</el-button>  &nbsp; &nbsp;
              <el-dialog
                title="提示" 
                
                :visible.sync="dialogVisible"
                width="20%"
                :before-close="handleClose">
                <span>确认删除吗？</span>
                <span slot="footer" class="dialog-footer">
                  <el-button @click="dialogVisible = false">取 消</el-button>
                  <el-button type="primary"  @click="dialogVisible =false ;deleteQuestion()">确 定</el-button>
                </span>
              </el-dialog>
              </br></br>                     
          </div>      
      </el-card>  

      <div class="block" style=" margin-left:40% ; margin-top:100px">
                <span class="demonstration"></span>
                <el-pagination
                @current-change="handleCurrentChange"
                :current-page.sync="currentPage"
                :page-size="4"
                layout="prev, pager, next ,jumper"
                :total="total">
                </el-pagination>
            </div>

    </div>  
</template>
<script>
import {quesPage,addQues,deleteQues,resetQues} from "@/api/change";


import urls from "urls-js";
    export default{
        data(){
            return {   
                currentPage: 1,
                testId:undefined,
                num : 1 ,                         
                loading:true,               
                list:[],
                total:0,
                lists:[],
                dialogImageUrl: '',
                imgVisible: false,
                dialogVisible :false,
                index: -1,
                dialogFormVisible: false ,
                addDesc: '',
                
          }
           
        },

        created(){
            this.testId = urls.parse().hash['testId'];
            this.getQuestions()           
        },

        methods:{
          deleteButton(resid){       
            this.index = resid            
          },
         
          handleCurrentChange(val) {
            this.currentPage = val
            
            this.getQuestions()
            
          }, 
          getQuestions(){
              quesPage(this.currentPage-1,4,this.testId).then(response=>{                   
                    this.list = response.data.content                   
                    this.lists = response.data.pageable
                    this.total = response.data.totalElements                  
              })
          },
          handleClose(done) {
            this.$confirm('确认关闭？')
              .then(_ => {
                done();
              })
              .catch(_ => {});
          },
          resetQuestion(nowId,newDesc){      
            resetQues(this.testId,nowId,newDesc).then(response=>{
              if(response.success){
                this.$message.success("修改成功！")              
              }else{
                this.$message.error('修改失败！');
              }
            })
        },
        addQuestion(){      
            addQues(this.testId,this.total+1,this.addDesc).then(response=>{
              if(response.success){
                this.$message.success("添加成功！") 
                location.reload()
              }else{
                this.$message.error('添加失败！');
              }
              
            })
        },
        deleteQuestion(){             
            deleteQues(this.testId,this.index).then(response=>{
              if(response.success){
                this.$message.success("删除成功！") 
                location.reload()
              }else{
                this.$message.error('删除失败！');
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

    
  