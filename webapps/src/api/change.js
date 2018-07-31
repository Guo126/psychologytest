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
        url:'/response/getResponse',
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

