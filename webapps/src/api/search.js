import request from '@/utils/request'

export function paperSearch(paperDesc){
    return request({
        url:'/paper/search',
        method: 'post',
        params: {paperDesc}
    })
}