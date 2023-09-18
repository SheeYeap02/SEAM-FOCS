function getProfile(id) {
    return $axios({
      url: `/profile/${id}`,
      method: 'get'
    })
}

// add new profile
function addProfile(params) {
  return $axios({
    url: '/profile/add',
    method: 'post',
    data: { ...params }
  })
}

// modify profile
function editProfile(params) {
  return $axios({
    url: '/profile/update',
    method: 'put',
    data: { ...params }
  })
}