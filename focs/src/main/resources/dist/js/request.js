(function (win) {
  axios.defaults.headers["Content-Type"] = "application/json;charset=utf-8";
  // Create axios instance
  const service = axios.create({
    //Axios's request configuration has the baseURL option, indicating the public part of the request URL
    baseURL: "/",
    // Set Timeout
    timeout: 10000,
  });

  // request handler
  service.interceptors.request.use((config) => {
      // Whether you need to set a token
      // const isToken = (config.headers || {}).isToken === false
      // if (getToken() && !isToken) {
      //   //Make each request carry a customized token. Modify it as you see fit
      //   config.headers['Authorization'] = 'Bearer ' + getToken()
      // }
      // Get request mapping params parameter
      if (config.method === "get" && config.params) {
        let url = config.url + "?";
        for (const propName of Object.keys(config.params)) {
          const value = config.params[propName];
          var part = encodeURIComponent(propName) + "=";
          if (value !== null && typeof value !== "undefined") {
            if (typeof value === "object") {
              for (const key of Object.keys(value)) {
                let params = propName + "[" + key + "]";
                var subPart = encodeURIComponent(params) + "=";
                url += subPart + encodeURIComponent(value[key]) + "&";
              }
            } else {
              url += part + encodeURIComponent(value) + "&";
            }
          }
        }
        url = url.slice(0, -1);
        config.params = {};
        config.url = url;
      }
      return config;
    },
    (error) => {
      console.log(error);
      Promise.reject(error);
    }
  );

  // response handler
  service.interceptors.response.use((res) => {
      console.log("---- ../page/login.html ----");
      if (res.data.code === 0 || res.data.msg === "NOTLOGIN") {
        // back to login page
         console.log("---- ../page/login.html ----");
         localStorage.removeItem("userInfo");
         alert('Halo Youre Here');
         window.top.location.href = "../page/login.html";
      } else {
        alert('Halo Youre Error Here');
        return res.data;
      }
    },
    (error) => {
      console.log("err" + error);
      let { message } = error;
      if (message == "Network Error") {
        message = "Backend Interface Connection Exception";
      } else if (message.includes("timeout")) {
        message = "System Interface Request Timeout";
      } else if (message.includes("Request failed with status code")) {
        message = "System Interface" + message.substr(message.length - 3) + "Exception";
      }
      // window.ELEMENT.Message({
      //   message: message,
      //   type: "error",
      //   duration: 5 * 1000,
      // });
      return Promise.reject(error);
    }
  );
  win.$axios = service;
})(window);
