<template >
    
       <div class="app-container" >
           </br> </br> 
            <el-progress :percentage="per" ></el-progress>
        <el-card  shadow="hover" class="box-card" :v-show="show">          
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
                <el-button style="float: right; padding: 3px 0" type="text"  @click = "nextQuestion">下一题</el-button>
                </br>
            </div>
  
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
            question : '' ,
            answer : 0 ,
            loading:true,
            maxnum: 0 ,
            per: 0 ,
            responseId:0,
            score: 0 ,
            list:[] ,
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
                alert(this.maxnum)
            })
        },

        getQuestions(){
            getQuestion(this.testId,this.num).then(response=>{
                this.loading = true
                if(response.success){
                    let data = response.data;
                    this.num = data.num;
                    this.question = data.desc
                    this.loading = false
                    this.per = parseInt(this.num *100/this.maxnum)
                }
            })
            
        },
        getResponseByScore(){                            
            getResByScore(this.testId,this.score).then(response=>{   
                if(response.success){
                    this.responseId= response.data.responseId 
                    alert(this.responseId) 
                }else{
                        alert("失败")         
                }          
                    
                          
            })
        },

        nextQuestion(){
            if(this.num==this.maxnum){   
                this.score += this.answer                              
                this.getResponseByScore()                         
                saveResponse(this.userId,this.responseId,this.score)
                alert("      您已完成测评,点击返回首页 "  )  
                this.$router.push('/example/table')
            }else{
                
                this.num++              
                this.getQuestions()
                this.score += this.answer
               
                
            }
            
            
        },
        
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

