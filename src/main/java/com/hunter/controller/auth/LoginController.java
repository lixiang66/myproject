package com.hunter.controller.auth;

import com.hunter.bean.user.User;
import com.hunter.propertis.ApplicaitonProperties;
import com.hunter.utils.JsonResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lixiang on 2018/3/14.
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

        Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
        RequestCache requestCache = new HttpSessionRequestCache();
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        @Autowired
        private ApplicaitonProperties applicaitonProperties;

        @GetMapping("/login")
        @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
        public Object login(HttpServletRequest request, HttpServletResponse response) throws IOException {
                SavedRequest savedRequest = requestCache.getRequest(request, response);
//                if(StringUtils.isNotEmpty(savedRequest.getRedirectUrl())
//                        ||savedRequest.getRedirectUrl().endsWith(".html")){
                logger.debug(savedRequest.getRedirectUrl());
                redirectStrategy.sendRedirect(request, response, applicaitonProperties.getLoginUrl());
//                }
                return JsonResultBuilder.fail("请转到登录页！");
        }

        @RequestMapping("/success")
        @ResponseStatus(code = HttpStatus.OK)
        public Object loginsuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (true) {
                        redirectStrategy.sendRedirect(request, response, "/admin/index");
                } else {
                        redirectStrategy.sendRedirect(request, response, "/user/index");
                }
                return null;
        }


}
