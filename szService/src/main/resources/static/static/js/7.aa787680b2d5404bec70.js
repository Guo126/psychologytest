webpackJsonp([7],{k3tE:function(t,s,e){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var n=e("8obM"),a=e("9Y1S"),r=e.n(a),i=e("uAC3"),o=e.n(i),c={data:function(){return{userId:void 0,testId:void 0,num:1,question:[],answer:0,loading:!0,maxnum:0,per:0,responseId:0,score:0}},created:function(){this.testId=r.a.parse().hash.testId,this.userId=o.a.get("userId"),this.getMaxnum(),this.getQuestions()},methods:{getMaxnum:function(){var t=this;Object(n.a)(this.testId).then(function(s){t.maxnum=s.data})},getQuestions:function(){var t=this;Object(n.c)(this.testId).then(function(s){if(t.loading=!0,s.success){var e=s.data;t.question=e,t.loading=!1}})},getResponseByScore:function(){var t=this;Object(n.d)(this.testId,this.score).then(function(s){s.success?(t.responseId=s.data.responseId,Object(n.f)(t.userId,t.responseId,t.score)):t.$message.error("生成报告失败！")})},nextQuestion:function(){this.num==this.maxnum?(this.score+=this.answer,this.getResponseByScore(),this.$message.success("      您已完成测评 "),this.$router.push("/example/table")):(this.num++,this.per=parseInt(100*this.num/this.maxnum),this.score+=this.answer)}}},u={render:function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"app-container"},[e("br"),t._v(" "),e("el-progress",{attrs:{percentage:t.per}}),t._v(" "),e("el-card",{staticClass:"box-card",staticStyle:{"margin-top":"50px",width:"600px"},attrs:{shadow:"hover"}},[e("span",[t._v("第"+t._s(t.num)+"题")]),t._v(" "),e("br"),e("br"),t._v(" "),e("br"),t._v(" "),e("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"text item"},[t._v("\n                "+t._s(t.question[t.num-1].desc)+"\n        ")]),t._v(" "),e("br"),t._v(" "),e("div",{staticClass:"block"},[e("span",{staticClass:"demonstration"},[t._v("请从下面5个级别中选择答案")]),t._v(" "),e("br"),t._v(" "),e("br"),t._v(" "),e("br"),t._v(" "),e("el-slider",{attrs:{step:1,max:4,"show-stops":""},model:{value:t.answer,callback:function(s){t.answer=s},expression:"answer"}}),t._v(" "),e("br"),e("br"),t._v(" "),e("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",round:""},on:{click:t.nextQuestion}},[t._v("下一题")]),t._v(" "),e("br")],1),e("br"),e("br"),t._v(" "),e("span",[t._v("0:非常不符合（0分）  1:比较不符合（1分）    2:不确定（2分）    3:比较符合（3分）    4:非常符合（4分）")])])],1)},staticRenderFns:[]};var d=e("vSla")(c,u,!1,function(t){e("sfP7")},null,null);s.default=d.exports},osZE:function(t,s,e){(t.exports=e("BkJT")(!1)).push([t.i,'\n.text {\n  font-size: 18px;\n}\n.item {\n  margin-bottom: 18px;\n}\n.clearfix:before,\n.clearfix:after {\n  display: table;\n  content: "";\n}\n.clearfix:after {\n  clear: both\n}\n.box-card {\n  width: 480px;\n  margin: 0 auto;\n  margin-top: 10%;\n}\n',""])},sfP7:function(t,s,e){var n=e("osZE");"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);e("8bSs")("78164f8a",n,!0)}});