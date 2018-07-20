<template>
  <div class="app-container">
    
      <el-card  v-for="(o,index) in list" :key="o.paperId" :body-style="{ padding: '0px' }"  :style="{'background-color':colors[index%3]}">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->

        <div style="padding: 14px;">
          <span>{{o.paperDesc}}</span>
          <div class="bottom clearfix">
            <time class="time">{{ currentDate }}</time>
            <el-button type="text" class="button" @click="handleDispatchSepcific">开始答题</el-button>
          </div>
        </div>
      </el-card>


     

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
      currentDate: new Date() ,
      list : [{
       
      }],
      colors:[
        "#58D3F7",
        '#F5A9E1',
        '#81F79F'
      ]

    };
  },
  
  methods:{
    getPaperInfo(){
      getPaper().then(response=>{
        if(response.success){
          this.list = response.data
        }
      })
    },


    handleDispatchSepcific(){
      
      this.$router.push('/example/testing?testId=1')
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
