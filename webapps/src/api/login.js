import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/user/getUser',
    method: 'get',
    params: {
      username,
      password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout(userId) {
  return request({
    url: '/user/logout',
    method: 'post',
    params:{
      userId
    }
  })
}


export function getUserInfo(userId) {
  
  return request({
    url: '/user/login',
    method: 'post',
    params: { userId }
  })
}
