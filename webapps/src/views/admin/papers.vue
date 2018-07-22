<template>
    <div class="app-container">
        <el-card  v-for="(o,index) in list" :key="o.paperId" :body-style="{ padding: '20px'}">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->

        <div style="padding: 14px;">
          <span>{{o.paperDesc}}</span>
          <div class="bottom clearfix">
            <time class="time">{{ currentDate }}</time>
            <el-button type="text" class="button" @click="handleDispatchSepcific(o.paperId)">开始答题</el-button>
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

