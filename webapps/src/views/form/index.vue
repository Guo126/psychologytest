<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="用户名">
        <el-input 
        placeholder="请输入用户名"
        v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input 
        placeholder="请输入密码"
        v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input 
        placeholder="请输入姓名"
        v-model="form.nickname"></el-input>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input
          placeholder="请输入手机号"
          v-model="form.phone"
          clearable>
          
        </el-input>
      </el-form-item>
     
      <el-form-item label="邮箱">
        <el-input
          placeholder="请输入邮箱"
          v-model="form.mail"
          clearable>
          
        </el-input>
      </el-form-item>
      <el-form-item label="出生日期">
       <el-col :span="11">
         <el-date-picker
           v-model="form.birthday"
           type="date"
           placeholder="选择日期"
           value-format="yyyy-MM-dd"
           style="width: 100%">
         </el-date-picker>
       </el-col>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="form.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
          <el-radio label="保密"></el-radio>
        </el-radio-group>
      </el-form-item>
      
      </br></br></br>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
        <el-button @click="onCancel">退出</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getUserInfo } from "@/api/login";
import {userChange} from "@/api/change";
import Cookie from 'js-cookie';

export default {
  data() {
    return {
      form: {
        username:'',
        nickname: '',
        phone:'',
        password: '',
        mail:'',
        birthday: '',               
        sex: '',
        desc: ''
        
      },
      userId:undefined,
    }
  },
  created(){
    this.userId = Cookie.get("userId");  
    this.fetchUserInfo()
  },
  methods: {
    fetchUserInfo(){
      getUserInfo(this.userId).then(response => {
        if (response.success) {
          this.form = response.data
        }
      })
    },
    onSubmit() {
      userChange(this.userId,this.form).then(response=>{
        if(response.success){
           this.$message('保存成功!')
          //  location.reload()
        }else{
          this.$message('保存失败!')
        }
      })
     
    },
    onCancel() {
      this.$message({
        message: '退出页面!',
        type: 'warning'
      })
    }
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

