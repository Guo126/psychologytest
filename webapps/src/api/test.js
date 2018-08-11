import request from '@/utils/request'

export function getPaper(page,pageSize){
    return request({
        url:'/paper/getPaper',
        method:'get',   
        params:{page,pageSize}
    })

}


export function getQuestion(paperId){
    return request({
        url:'/question/questionList',
        method: 'get',
        params: {paperId }
    })
}


export function getCount(paperId){
    return request({
        url:'/question/questionCount',
        method:'get',
        params: {paperId}
    })

}

export function getResponse(userId){
    return request({
        url:'/answer/responseList',
        method: 'get',
        params:{userId}

    })
}

export function saveResponse(userId,responseId,score){
    return request({
        url:'/score/saveResponse',
        method:'post',
        params:{userId,responseId,score}
    })
}

export function getResByScore(paperId,score){
    return request({
        url:'/response/getResponseByScore',
        method:'get',
        params:{paperId,score}
    })
}

export function getResponsePage(page,pageSize){
    return request({
        url:'/response/getResponseWithPage',
        method:'get',
        params:{page,pageSize}
    })
}