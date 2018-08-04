<template>
  <div class="app-container">
      <el-card  v-for="(o,index) in list" :key="o.paperId" :body-style="{ padding: '20px' }"  :style="{'background-color':colors[index%3] }" style="margin-top:6px">
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
                :total="total">
                </el-pagination>
      </div>
  </div>
</template>


<script>
import {getPaper} from "@/api/test";
export default {
  data() {
    return {
      currentDate: new Date() ,
      currentPage: 1,
      list : [],
      page: [],
      total:0,
      colors:[
        "#58D3F7",
        '#F5A9E1',
        '#81F79F'
      ]

    };
  },
  created(){
    this.getPapers();
    
  },
  
  methods:{
    handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
    handleCurrentChange(val) {
        this.currentPage = val
        this.getPapers()       
      },
   
    getPapers(){
      getPaper(this.currentPage-1,4).then(response=>{
        if(response.success){                
          this.list = response.data.content                
          this.total = response.data.totalElements
         
        }
      })
    },
  handleDispatchSepcific(nowTestId){
      this.$router.push('/example/testing?testId='+nowTestId)
    },
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
