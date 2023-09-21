function getIntake(id) {
    return $axios({
      url: `/intake/${id}`,
      method: 'get'
    })
}

// add new intake
function addIntake(params) {
  return $axios({
    url: '/intake/add',
    method: 'post',
    data: params
  })
}

// modify intake
function editIntake(params) {
  return $axios({
    url: '/intake/update',
    method: 'put',
    data: params
  })
}