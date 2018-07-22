<template> 
    <div class="app-container" >
        
    
    
        <el-card class="box-card" style="background-color:#81BEF7">
            <div slot="header" class="clearfix">
                <span>MBTI性格类型测试报告</span>
                
            </div>
            <div  class="text item">
                &nbsp;&nbsp;{{score}}分
            </div>
            <div class="block">
                
                <el-button style="float: right; padding: 3px 0" type="text" @click="check">查看详情</el-button>
                </br>
            </div>
  
        </el-card>
        
    

    </div>

    
</template>

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
    
   
  }
</style>

<script>
export default {
    data(){
        return {
            score: 0

        }
    },
    created(){
        getScore();
    },
    methods:{
        check(){
            this.$router.push('/example/details?reportId=1');
        },
        getScore(){
            this.score = 86

        }
    }
}
</script>

