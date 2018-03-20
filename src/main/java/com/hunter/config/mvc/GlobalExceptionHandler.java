package com.hunter.config.mvc;

import com.hunter.utils.JsonResultBuilder;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lixiang on 2018/3/13.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

        @ResponseBody
        @ExceptionHandler(value = Exception.class)
        public Object allExceptionHandler(HttpServletResponse response, Exception exception) {
                System.out.println(response.getStatus());
                System.out.println(response.getContentType());
                System.out.println(response.getHeaderNames());
                exception.printStackTrace();
                return JsonResultBuilder.error(exception.getMessage());
        }

        @ExceptionHandler(value = MultipartException.class)
        public String allExceptionHandler1(HttpServletRequest request,HttpServletResponse response, Exception exception) throws IOException {
                System.out.println(exception.getMessage());
                //redirectStrategy.sendRedirect(request,response,"/error.html");
               return "error";
        }
}
