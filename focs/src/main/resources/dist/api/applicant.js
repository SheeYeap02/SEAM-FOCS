function getApplicantProfile(params) {
  return $axios({
    url: '/applicant/page',
    method: 'get',
    params
  })
}

// add new user
function addApplicant(params) {
  return $axios({
    url: '/applicant/signup',
    method: 'post',
    data: { ...params }
  })
}

// function signUpApi(data) {
//   return $axios({
//     'url': '/applicant/signup',
//     'method': 'post',
//     data
//   })
// }

// modify user
function editApplicant(params) {
  return $axios({
    url: '/applicant',
    method: 'put',
    data: { ...params }
  })
}

// Modify page back checking details interface
function queryProfileById (id) {
  return $axios({
    url: `/applicant/${id}`,
    method: 'get'
  })
}