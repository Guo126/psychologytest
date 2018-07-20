<template >
    
       <div class="app-container" >
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>第{{num}}题</span>
                
            </div>
            <div  class="text item">
                &nbsp;&nbsp;{{question}}
            </div>
            <div class="block">
                <span class="demonstration">从下面5个级别中选择</span>
                <el-slider
                v-model="answer"
                :step="1"
                max = 5
                show-stops>
                </el-slider>
                <el-button style="float: right; padding: 3px 0" type="text" @click = "nextQuestion">下一题</el-button>
                </br>
            </div>
  
        </el-card>

        
    </div>
    
</template>

<script>

    export default{
        data(){
            return{
                num : 1 ,
                question : '' ,
                answer : 0 ,
                
            }
           
        },

        created(){
            this.getQuestion();

        },

        methods:{
            getQuestion(){
                this.num = 1 ;
                this.question='我是第'+this.num +'题'; 
                
            },
            nextQuestion(){
                this.num++;
                this.question='我是第'+this.num +'题';
                
            }

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

