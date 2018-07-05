import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/table/list',
    method: 'get',
    params
  })
}

export function test(params) {
  return request({
    url:'/test',
    method:'post',
    params:params
  })
}
