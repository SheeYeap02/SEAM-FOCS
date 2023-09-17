function loginApi(data) {
    return $axios({
      'url': '/applicant/login',
      'method': 'post',
      data
    })
}
  
function logoutApi(){
    return $axios({
      'url': '/applicant/logout',
      'method': 'post',
    })
}


  