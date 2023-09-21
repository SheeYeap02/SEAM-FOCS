function getAllQueries() {
    return $axios({
      url: '/queries/list',
      method: 'get'
    });
  }
  
  function getQuery(queryId) {
    return $axios({
      url: `/queries/${queryId}`,
      method: 'get'
    });
  }
  
  // Add a new query
  function addQuery(params) {
    return $axios({
      url: '/queries/add',
      method: 'post',
      data: { ...params }
    });
  }
  
  // Modify a query
  function editQuery(params) {
    return $axios({
      url: '/queries/update',
      method: 'put',
      data: { ...params }
    });
  }
  
  // Delete a query by ID
  function deleteQuery(queryId) {
    return $axios({
      url: `/queries/${queryId}`,
      method: 'delete'
    });
  }
  