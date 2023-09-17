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
    url: '/applicant',
    method: 'post',
    data: { ...params }
  })
}

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