// get record with STPM/A LEVEL/ UEC/EQUIVALENT (IF APPLICABLE)
function getQualificationSTPM(id) {
  return $axios({
    url: `/qualification/stpm/${id}`,
    method: 'get'
  })
}

// add new profile
function addQualificationSTPM(params) {
  return $axios({
    url: '/qualification/stpm/add',
    method: 'post',
    data: { ...params }
  })
}

// modify profile
function editQualificationSTPM(params) {
  return $axios({
    url: '/qualification/stpm/update',
    method: 'put',
    data: { ...params }
  })
}