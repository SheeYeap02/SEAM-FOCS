function getDetailedInfo(id) {
    return $axios({
      url: `/detailedInfo/${id}`,
      method: 'get'
    })
}

// add new detailed info
function addDetailedInfo(params) {
  return $axios({
    url: '/detailedInfo/add',
    method: 'post',
    data: params,
    headers: { 'Content-Type': 'multipart/form-data' }
  })
}

// modify detailed info
function editDetailedInfo(params) {
  return $axios({
    url: '/detailedInfo/update',
    method: 'put',
    data: params,
    headers: { 'Content-Type': 'multipart/form-data' }
  })
}