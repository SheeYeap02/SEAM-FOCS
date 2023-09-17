package com.seam.focs.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Handle Global Exception
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * Exception Handle Method
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")) {
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "already existed";
            return Result.error(msg);
        }

        return Result.error("Unknown Error");
    }

    /**
     * Exception Handle Method
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public Result<String> exceptionHandler(CustomException ex) {
        log.error(ex.getMessage());
        return Result.error(ex.getMessage());
    }
}
