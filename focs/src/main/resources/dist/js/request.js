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
         console.log("---- /dist/page/login.html ----");
         localStorage.removeItem("userInfo");
         window.location.href = "dist/page/login.html";
      } else {
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
      return Promise.reject(error);
    }
  );
  win.$axios = service;
})(window);
