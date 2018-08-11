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

export function register(form){
  return request({
    url: '/user/register',
    method: 'post',
    params:{username:form.username,
      nickname:form.nickname,
      password:form.password,
      sex:form.sex,
      phone:form.phone,
      mail:form.mail,
      desc:form.desc,
      birthday:form.birthday}
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

export function userSearch(nickname){
  return request({
    url: '/user/search',
    method: 'post',
    params:{nickname}
  })
}

export function userDelete(userId){
  return request({
    url: '/user/delete',
    method: 'post',
    params:{userId}
  })
}
