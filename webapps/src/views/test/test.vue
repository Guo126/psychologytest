<template >
    
       <div class="app-container" >
           </br> </br> 
            <el-progress :percentage="per" ></el-progress>
        <el-card  shadow="hover" class="box-card" v-show="show">          
            <span>第{{num}}题</span>
            </br></br>
            <div  class="text item"   v-loading="loading">
                &nbsp;&nbsp;&nbsp;&nbsp;{{question}}
            </div>
            </br></br>
            <div class="block">
                <span class="demonstration">从下面5个级别中选择答案</span>
                </br> </br> </br>
                <el-slider
                v-model="answer"
                :step="1"
                max = 5
                show-stops>
                </el-slider>
                </br></br></br>
                <el-button style="float: right; padding: 3px 0" type="text" @click = "nextQuestion">下一题</el-button>
                </br>
            </div>
  
        </el-card>

        
    </div>
    
</template>

<script>
import {getQuestion} from "@/api/test" ;
import urls from "urls-js";
import {getCount} from "@/api/test";

    export default{
        data(){
            return{
                testId:undefined,
                num : 1 ,
                question : '' ,
                answer : 0 ,
                loading:true,
                maxnum: 0 ,
                per: 0 ,
                show : 'true',
                score: 0 ,
            }
           
        },

        created(){
            this.testId = urls.parse().hash['testId']
            this.getMaxnum();
            this.getQuestions();
        },

        methods:{

            getMaxnum(){
                getCount(this.testId).then(response=>{
                    this.maxnum = response.data;
                })
            },

            getQuestions(){
                getQuestion(this.testId,this.num).then(response=>{
                    this.loading = true
                    if(response.success){
                        let data = response.data;
                        this.num=data.num;
                        this.question = data.desc
                        this.loading = false
                        this.per = (this.num*100/this.maxnum)
                    }
                })
                
            },
            nextQuestion(){
                if(this.num==this.maxnum){
                    this.show = "false"

                }else{
                    this.num++;
                    this.getQuestions()
                    this.score += this.answer
                }
                
                
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

