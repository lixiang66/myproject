package com.hunter.config.mvc;

import com.hunter.utils.JsonResultBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lixiang on 2018/3/13.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

        @ResponseBody
        @ExceptionHandler(value = Exception.class)
        public Object allExceptionHandler(Exception exception) {
                exception.printStackTrace();
                return JsonResultBuilder.error(exception.getMessage());
        }
}
