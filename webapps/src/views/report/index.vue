<template> 
    <div class="app-container" >
        <el-card  v-for="(o,index) in list" :key="o.responseId" :body-style="{ padding: '20px'}" style="background-color:#E0ECF8 ; margin-top:6px;margin-left:240px;width:800px">
        
        <div style="padding: 14px;">
             </br><div style="font-size:21px">
              <span>{{o.paperDesc}}&nbsp;&nbsp;报告</span>&nbsp;&nbsp;&nbsp;</br></br>
            </div>
                 
          <el-button type="primary" round @click="check(o.responseDesc,o.responseId);dialogVisible =true" style="float:right;">查看详情&nbsp;&nbsp;</el-button></br>
          <el-dialog
            title="详情"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <div v-for="n in imgList" :key="n.imgId" style="margin-left:120px ">
              <img  width="600px" height="400px" :src="n.imgUrl">
            </div></br></br>
            <span style="margin-left:100px">&nbsp;&nbsp;{{inde}}</span>
            <span slot="footer" class="dialog-footer">
            <el-button type="primary"  @click="dialogVisible =false ">返回</el-button>
            </span>
          </el-dialog>
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
import {getImg} from "@/api/change";
import Cookie from 'js-cookie'

export default {
    data(){
        return {
            imgList:[],
            list:[] ,
            userId : 0,
            dialogVisible :false,
            inde:'',
            resId:0,
        }
    },
    created(){
        this.userId = Cookie.get("userId");       
        this.getRes(); 
             
    },
    methods:{
        getImgList(){
          getImg(this.resId).then(response=>{
            if(response.success){
              this.imgList = response.data
            }else{
              this.$message("获取失败！")
            }
          })
        },
        check(desc,id){
            this.inde = desc
            this.resId = id
            this.getImgList()
        },
        getRes(){
            getResponse(this.userId).then(response=>{
                let data = response.data;
                this.list = data;           
            })
        },
        handleClose(done) {
         this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
       
    }
}
</script>

