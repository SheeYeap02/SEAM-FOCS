// add new user
function updateApplication (params) {
  return $axios({
    url: '/application/update',
    method: 'put',
    data: { ...params }
  })
}

// Modify page back checking details interface
function getApplication (id) {
  return $axios({
    url: `/application/${id}`,
    method: 'get'
  })
}