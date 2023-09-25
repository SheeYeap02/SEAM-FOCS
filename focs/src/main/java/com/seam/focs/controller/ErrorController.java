package com.seam.focs.controller;

import com.seam.focs.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public Result<String> handleError(HttpServletRequest request) {
        // Handle the error and return an appropriate view
        return Result.error("Error");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
