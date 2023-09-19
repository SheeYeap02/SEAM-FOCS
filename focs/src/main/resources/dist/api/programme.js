function getAllProgramme() {
    return $axios({
      url: `/programme/list`,
      method: 'get'
    })
}

function getProgramme(id) {
    return $axios({
      url: `/programme/${id}`,
      method: 'get'
    })
}

// add new profile
function addProgramme(params) {
  return $axios({
    url: '/programme/add',
    method: 'post',
    data: { ...params }
  })
}

// modify profile
function editProgramme(params) {
  return $axios({
    url: '/programme/update',
    method: 'put',
    data: { ...params }
  })
}