<template> 
    <div class="app-container" >
        <el-card  v-for="(o,index) in list" :key="o.responseId" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px">
        <!-- <img src="~examples/assets/images/hamburger.png" class="image"> -->
        <div style="padding: 14px;">
             <span>{{o.paperDesc}}&nbsp;&nbsp;报告</span>&nbsp;&nbsp;&nbsp;
            </br></br>
          <span >{{o.responseDesc}} </span>         
          
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
import {getResponse} from '@/api/test'
import Cookie from 'js-cookie'

export default {
    data(){
        return {
            score: 0,
            list:[] ,
            userId : 0,
        }
    },
    created(){
        this.userId = Cookie.get("userId");       
        this.getRes();       
    },
    methods:{
        check(){
            this.$router.push('/example/details?reportId=1');
        },
        getRes(){
            getResponse(this.userId).then(response=>{
                let data = response.data;
                this.list = data;           
            })
        },
       
    }
}
</script>

