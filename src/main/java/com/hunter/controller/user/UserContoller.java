package com.hunter.controller.user;

import com.hunter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixiang on 2018/3/14.
 */
@RestController
@RequestMapping("/user")
public class UserContoller {

        @Autowired
        UserService userService;

        @RequestMapping("/index")
        public Object toIndex() {
                return userService.getUsers("lixiang");
        }
}
