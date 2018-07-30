import request from '@/utils/request'

export function getPaper(){
    return request({
        url:'/paper/getPaperList',
        method:'get',   

    })

}


export function getQuestion(paperId,numId){
    return request({
        url:'/question/aQuestion',
        method: 'get',
        params: {paperId ,numId}
    })
}

export function getCount(paperId){
    return request({
        url:'/question/paperCount',
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