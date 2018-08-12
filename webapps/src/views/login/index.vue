<template>
<div class="login-container" style="background:url('back.jpg');background-size:100% auto">
<el-form class="login-form" autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left">
<h3 class="title">心理测试系统</h3>
<el-form-item prop="username" >
<span class="svg-container svg-container_login">
<svg-icon icon-class="user" />
</span>
<el-input  class="el-input1" name="username" type="text" v-model="loginForm.username" autoComplete="on" placeholder="请输入用户名" />
</el-form-item>
<el-form-item prop="password">
<span class="svg-container">
<svg-icon icon-class="password"></svg-icon>
</span>
<el-input class="el-input1" name="password" :type="pwdType" @keyup.enter.native="handleLogin" v-model="loginForm.password" autoComplete="on"
placeholder="请输入密码"></el-input>
<span class="show-pwd" @click="showPwd"><svg-icon icon-class="eye" /></span>
</el-form-item>

    <div style="display:flex;flex-direction:row-reverse">
        <el-button type="primary"  style="margin-left:20px" :loading="loading" @click.native.prevent="handleLogin">
          登录
        </el-button>
        <el-button type="success"  :loading="loading" @click="dialogFormVisible=true">
          注册
        </el-button>
      </div>

</el-form> 
 <el-dialog style="z-index:10 ;color:black;border:1px ;solid red" title="用户注册" :visible.sync="dialogFormVisible">
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
           value-format="yyyyMMdd"            
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
    </el-form>
        <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false; addUser()">提交</el-button>
        </div>
    </el-dialog>
</div> 
</template>

<script>
import { isvalidUsername } from '@/utils/validate'
import {register} from '@/api/login'

export default {
name: 'login',
data() {
const validateUsername = (rule, value, callback) => {
if (value.length<1) {
callback(new Error('请输入正确的用户名'))
} else {
callback()
}
}
const validatePass = (rule, value, callback) => {
if (value.length < 5) {
callback(new Error('密码不能小于5位'))
} else {
callback()
}
}
return {
loginForm: {
username: '',
password: ''
},
loginRules: {
username: [{ required: true, trigger: 'blur' ,validator: validateUsername}],
password: [{ required: true, trigger: 'blur', validator: validatePass }]
},
loading: false,
pwdType: 'password',
dialogFormVisible:false,
form:{
  username:'',
  nickname:'',
  password:'',
  sex:'',
  phone:'',
  mail:'',
  desc:'',
  birthday:'',
}

}
},
methods: {
addUser(){
  register(this.form).then(response=>{
    
    if(response.success){
      this.loginForm.username = this.form.username
      this.loginForm.password = this.form.password
      alert("注册成功!")
    }else{
      alert("请填写完整信息！")
    }
  })
},
showPwd() {
if (this.pwdType === 'password') {
this.pwdType = ''
} else {
this.pwdType = 'password'
}
},
handleLogin() {
this.$refs.loginForm.validate(valid => {
if (valid) {
this.loading = true
this.$store.dispatch('Login', this.loginForm).then(() => {
this.loading = false
this.$router.push({ path: '/' })
}).catch(() => {
this.loading = false
})
} else {
console.log('error submit!!')
return false
}
})
}
}
}
</script>

<style rel="stylesheet/scss" lang="scss">
$bg:#2d3a4b;
$light_gray:#eee;

/* reset element-ui css */
.login-container {
.el-input1 {
display: inline-block;
height: 47px;
width: 85%;
input {
background: transparent;
border: 1px;
-webkit-appearance: none;
border-radius: 1px;
padding: 12px 5px 12px 15px;
height: 47px;
&:-webkit-autofill {
-webkit-box-shadow: 0 0 0px 1000px $bg inset !important;
-webkit-text-fill-color: #fff !important;
}
}
}


}

</style>

<style rel="stylesheet/scss" lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;
.login-container {
height: 100%;
width: 100%;
background-color: $bg;
.login-form {
position: absolute;
left: 0;
right: 0;
width: 520px;
padding: 35px 35px 15px 35px;
margin: 120px auto;
}
.tips {
font-size: 14px;
color: #fff;
margin-bottom: 10px;
span {
&:first-of-type {
margin-right: 16px;
}
}
}
.svg-container {
padding: 6px 5px 6px 15px;
color: $dark_gray;
vertical-align: middle;
width: 30px;
display: inline-block;
&_login {
font-size: 20px;
}
}
.title {
font-size: 26px;
font-weight: 400;
color: $light_gray;
margin: 0px auto 40px auto;
text-align: center;
font-weight: bold;
}
.show-pwd {
position: absolute;
right: 10px;
top: 7px;
font-size: 16px;
color: $dark_gray;
cursor: pointer;
user-select: none;
}
}
</style>