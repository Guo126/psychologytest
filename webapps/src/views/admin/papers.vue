<template>
    <div class="app-container" >
      &nbsp;&nbsp;&nbsp;
        <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>
     &nbsp;&nbsp;&nbsp;
     <el-button type="primary" icon="el-icon-search">搜索</el-button> 
        <div style="float:right">
        <el-button type="primary" icon="el-icon-plus"  @click="addPaper()">添加</el-button> 
        </div>
        </br></br></br>
        <el-card  v-for="(o,index) in list" :key="o.paperId" :body-style="{ padding: '20px'}">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->

        <div style="padding: 14px;">
          <el-input v-model="o.paperDesc" style="width:500px"> </el-input>
          <el-button type="primary" @click="renamePaper(o.paperId,o.paperDesc)">保存</el-button>
          <div class="bottom clearfix">
            <time class="time">{{ currentDate }}</time>
              
            <el-button type="text" class="button" @click="dialogVisible = true ;deleteButton(o.paperId)">&nbsp;&nbsp;删除试卷 &nbsp;&nbsp;</el-button>
            <el-dialog
              title="提示"
              :visible.sync="dialogVisible"
              width="20%"
              :before-close="handleClose">
              <span>确认删除吗？</span>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary"  @click="dialogVisible =false ;deletePapers()">确 定</el-button>
              </span>
            </el-dialog>
             &nbsp;&nbsp;
            <el-button type="text" class="button" @click="changeQuestion(o.paperId)">修改试题&nbsp;&nbsp;</el-button>
           
            <el-button type="text" class="button" @click="changeResponse(o.paperId)">修改报告&nbsp;&nbsp;</el-button>
          </div>
        </div>
        
      </el-card>
     
         <div class="block" style=" margin-left:40% ; margin-top:100px">
            <span class="demonstration"></span>
            <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="currentPage"
            :page-size="5"
            layout="prev, pager, next"
            :total="10">
            </el-pagination>
        </div>
    </div>
</template>

<script>
import {getPaper} from "@/api/test";
import {deletePaper} from "@/api/change";
import {namePaper} from "@/api/change";

export default {

  created(){
    this.getPaperInfo(); 
  },

  data() {
    return {
      
      currentPage: 1,
      dialogVisible: false ,
      currentDate: new Date() ,
      list : [],
      lists:[],
      index: -1,
     
    };
  },
  
  methods:{
   
      deleteButton(paperid){
        
        this.index = paperid
        
      },

      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
      getPaperInfo(){
        getPaper(0,5).then(response=>{
          if(response.success){
            this.list = response.data.content
            this.lists = response.data.pageable
            console(this.list[0])
            alert(this.lists.totalElements)
         }
      })
    },
    addPaper(){
        this.$router.push('/admin/addp')
    },

    renamePaper(nowId,newName){
      
      namePaper(nowId,newName).then(response=>{
         if(response.success){
           
           alert("修改成功！")
           location.reload()
         }else{
           alert("修改失败！")
         }
       })
    },
    
    deletePapers(){
       deletePaper(this.index).then(response=>{
         
          
         if(response.success){
           alert("删除成功！")
           location.reload()
         }else{
           alert("删除失败！")
         }
       })
       
    },
    
    changeQuestion(nowTestId){
        this.$router.push('/admin/changequestion?testId='+nowTestId);
    },
    changeResponse(nowTestId){
        this.$router.push('/admin/changeresponse?testId='+nowTestId);
    },


    handleDispatchSepcific(nowTestId){
      this.$router.push('/example/testing?testId='+nowTestId)
    },

    handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    
  }
}
</script>


<style>
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>

