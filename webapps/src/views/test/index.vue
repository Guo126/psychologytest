<template>
  <div class="app-container">
     
  
    <el-card :body-style="{ padding: '0px' }" >
      <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
      <div style="padding: 14px;">
        <span>MBTI性格类型测试问卷</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button" @click="handleDispatchSepcific">开始答题</el-button>
        </div>
      </div>
    </el-card>

      <el-card :body-style="{ padding: '0px' }">
      <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
      <div style="padding: 14px;">
        <span>职场学生测试问卷</span>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>
          <el-button type="text" class="button" onclick="">开始答题</el-button>
        </div>
      </div>
    </el-card>


  </div>
</template>

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

<script>
export default {
  data() {
    return {
      currentDate: new Date()
    };
  },
  methods:{
    handleDispatchSepcific(){
      
      this.$router.push('/example/testing?testId=1')
    }
  }
}
</script>
