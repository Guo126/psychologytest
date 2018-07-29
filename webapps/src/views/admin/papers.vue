<template>
    <div class="app-container" >
      &nbsp;&nbsp;&nbsp;
        <el-input v-model="input" placeholder="请输入内容" style="float:left;width:400px"></el-input>
     &nbsp;&nbsp;&nbsp;
     <el-button type="primary" icon="el-icon-search">搜索</el-button> 
        <el-button type="primary" icon="el-icon-plus" style="float:right" @click="addPaper()">添加</el-button> 
        </br></br></br>
        <el-card  v-for="(o,index) in list" :key="o.paperId" :body-style="{ padding: '20px'}">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->

        <div style="padding: 14px;">
          <span>{{o.paperDesc}}</span>
          <div class="bottom clearfix">
            <time class="time">{{ currentDate }}</time>
            <el-button type="text" class="button" @click="changePaper(o.paperId)">&nbsp;&nbsp;修改试卷 &nbsp;&nbsp;</el-button>
            &nbsp;&nbsp;
            <el-button type="text" class="button" @click="changeQuestion(o.paperId)">修改试题&nbsp;&nbsp;</el-button>
           
            <el-button type="text" class="button" @click="changeResponse(o.paperId)">修改报告&nbsp;&nbsp;</el-button>
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
import {getPaper} from "@/api/test";


export default {

  created(){
    this.getPaperInfo();
    console.log(this.list);
    
  },

  data() {
    return {
         currentPage: 1,
       
      currentDate: new Date() ,
      list : [{
       
      }],
     
    };
  },
  
  methods:{
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
      getPaperInfo(){
        getPaper().then(response=>{
          if(response.success){
            this.list = response.data
         }
      })
    },
    addPaper(){
        this.$router.push('/admin/addp')
    },
    changePaper(nowTestId){
        this.$router.push('/admin/changep?testId='+nowTestId);
    },
    changeQuestion(nowTestId){
        this.$router.push('/admin/changequestion?testId='+nowTestId);
    },
    changeResponse(nowTestId){
        this.$router.push('/admin/changeresponse?testId='+nowTestId);
    },


    handleDispatchSepcific(nowTestId){
      this.$router.push('/example/testing?testId='+nowTestId)
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

