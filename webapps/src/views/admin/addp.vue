<template>
    <div class="app-container" >

    <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="试卷名称">
        <el-input v-model="name"></el-input>
    </el-form-item>  
    <el-form-item label="添加题目">
        <el-input type="textarea" v-model="question" style="height:200px;width:70%"></el-input>
    </el-form-item>
    <el-form-item label="添加报告">
        <el-input type="textarea" v-model="report"></el-input>
    </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="addPapers()">立即创建</el-button>
        <el-button>取消</el-button>
    </el-form-item>
    </el-form>
    </div>
</template>
<script>
import {addPaper} from '@/api/change';

  export default {
    data() {
      return {
        
          name: '',
          question:'',
          report: ''
        
      }
    },
    methods: {
      addPapers(){
        addPaper(this.name);
        alert("创建成功！")
        this.$router.push('/admin/papers')
      },
      
    }
  }
</script>