import request from '@/utils/request'


export function getQues(paperId){
   return request({
       url:'/question/questionList',
       method: 'get',
       params: {  paperId }
                
   })
}

export function getRes(paperId){
    return request({
        url:'/response/getResponseDetail',
        method:'get',
        params:{paperId}
    })
}
export function namePaper(paperId,paperDesc){
    return request({
        url:'/paper/rename',
        method:'post',
        params:{paperId,paperDesc}
    })
}
export function addPaper(paperDesc){
    return request({
        url:'/paper/add',
        method:'post',
        params:{paperDesc}
    })
}

export function deletePaper(paperId){
    return request({
        url:'/paper/delete',
        method:'post',
        params:{paperId}
    })
}

export function quesPage(page,pageSize,paperId){
    return request({
        url:'/question/getQuestion',
        method:'get',
        params:{page,pageSize,paperId}
    })
}

export function addQues(paperId,questionNum,questionDesc){
    return request({
        url:'/question/add',
        method:'post',
        params:{paperId,questionNum,questionDesc}
    })
}

export function deleteQues(paperId,questionNum){
    return request({
        url:'/question/delete',
        method:'post',
        params:{paperId,questionNum}
    })
}

export function resetQues(paperId,questionNum,questionDesc){
    return request({
        url:'/question/reset',
        method:'post',
        params:{paperId,questionNum,questionDesc}
    })
}
export function addRes(responseDesc,paperId,minScore){
    return request({
        url:'/response/add',
        method:'post',
        params:{responseDesc,paperId,minScore}
    })
}

export function deleteRes(responseId){
    return request({
        url:'/response/delete',
        method:'post',
        params:{responseId}
    })
}

export function resetRes(responseId,minScore,responseDesc){
    return request({
        url:'/response/reset',
        method:'post',
        params:{responseId,minScore,responseDesc}
    })
}

 export function userChange(userId,form){
     return request({
         url:'/user/change',
         method:'post',
         params:{userId},
         data:{username:form.username,
               password:form.password,
               nickname:form.nickname,
               phone:form.phone,
               sex:form.sex,              
               mail:form.mail,
               birthday:form.birthday},
     })
 }

 export function getImg(responseId){
     return request({
         url:'/response/getImg',
         method:'get',
         params:{responseId}
     })
 }

 export function saveImg(params){
    return request({
        url:'/response/saveImg',
        method:'post',
        contentType:'multipart/form-data',
        data: params
    })
 }



