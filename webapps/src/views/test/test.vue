<template >
    
       <div class="app-container" >
           </br> 
            <el-progress :percentage="per" ></el-progress>
        <el-card  shadow="hover" class="box-card" style="margin-top:50px;width:600px">          
            <span>第{{num}}题</span>
            </br></br> </br>
            <div  class="text item"   v-loading="loading">
                &nbsp;&nbsp;&nbsp;&nbsp;{{question[num-1].desc}}
            </div>
            </br>
            <div class="block">
                <span class="demonstration">请从下面5个级别中选择答案</span>
                </br> </br> </br>
                <el-slider
                v-model="answer"
                :step="1"
                :max = 4
                show-stops>
                </el-slider>
                </br></br>
                <el-button style="float: right; padding: 3px 0" type="text"  @click = "nextQuestion">下一题</el-button>
                </br>
            </div></br></br>
            <span>0:非常不符合（0分）  1:比较不符合（1分）    2:不确定（2分）    3:比较符合（3分）    4:非常符合（4分）</span>
        </el-card>

        
    </div>
    
</template>

<script>
import {getQuestion} from "@/api/test" ;
import urls from "urls-js";
import {getCount} from "@/api/test";
import {getResByScore} from "@/api/test";
import {saveResponse} from "@/api/test";
import Cookie from 'js-cookie'

export default{
    data(){
        return{
            userId:undefined,
            testId:undefined,
            num : 1 ,
            question : []  ,
            answer : 0 ,
            loading:true,
            maxnum: 0 ,
            per: 0 ,
            responseId:0,
            score: 0 ,
            
        }
        
    },

    created(){
        this.testId = urls.parse().hash['testId']
        this.userId = Cookie.get("userId")
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
            getQuestion(this.testId).then(response=>{
                this.loading = true
                if(response.success){
                    let data = response.data;                  
                    this.question = data
                    this.loading = false
                    
                }
            })
            
        },
        getResponseByScore(){                            
            getResByScore(this.testId,this.score).then(response=>{   
                if(response.success){
                    this.responseId= response.data.responseId 
                    saveResponse(this.userId,this.responseId,this.score)
                    
                }else{
                        this.$message.error('生成报告失败！');
                }          
                    
                          
            })
        },

        nextQuestion(){
            if(this.num==this.maxnum){   
                this.score += this.answer                              
                this.getResponseByScore()                                                    
                this.$message.success("      您已完成测评 "  )  
                this.$router.push('/example/table')
            }else{               
                this.num++              
                this.per = parseInt(this.num *100/this.maxnum)
                this.score += this.answer
               
                
            }
            
            
        },
        
    }
}
</script>

<style>
  .text {
    font-size: 18px;
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

