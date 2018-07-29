import request from '@/utils/request'


export function getQues(paperId){
   return request({
       url:'/question/questionList',
       method: 'get',
       params: {  paperId }
                
   })
}