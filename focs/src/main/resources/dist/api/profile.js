function getProfile(id) {
    return $axios({
      url: `/profile/${id}`,
      method: 'get'
    })
}

// add new profile
function addProfile(params) {
  return $axios({
    url: '/profile',
    method: 'post',
    data: { ...params }
  })
}

// modify profile
function editProfile(params) {
  return $axios({
    url: '/profile',
    method: 'put',
    data: { ...params }
  })
}