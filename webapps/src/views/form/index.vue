<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
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
      <!-- <el-form-item label="验证码">
        <el-input 
        placeholder="请输入验证码"
        v-model="form.code"></el-input>
      </el-form-item> -->
      <el-form-item label="邮箱">
        <el-input
          placeholder="请输入邮箱"
          v-model="form.mail"
          clearable>
          <!-- <el-button slot="append" style="color:#409EFF;" >发送验证码</el-button> -->
        </el-input>
      </el-form-item>
      <el-form-item label="出生日期">
       <el-col :span="11">
         <el-date-picker
           v-model="form.date"
           type="date"
           placeholder="选择日期"
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
      <el-form-item label="备注">
        <el-input type="textarea" v-model="form.desc"></el-input>
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
export default {
  data() {
    return {
      form: {
        nickname: '',
        phone:'',
        code: '',
        mail:'',
        region: '',
        date: '',
        delivery: false,
        type: [],
        sex: '',
        desc: ''
        
      }
    }
  },
  created(){
    this.fetchUserInfo()
  },
  methods: {
    fetchUserInfo(){
      let userId = 2;
      getUserInfo(userId).then(response => {
        if (response.success) {
          this.form = response.data
        }
      })
    },
    onSubmit() {
      this.$message('保存成功!')
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

