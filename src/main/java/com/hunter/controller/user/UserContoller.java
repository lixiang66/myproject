package com.hunter.controller.user;

import com.hunter.service.UserService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
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

        @Autowired
        RuntimeService runtimeService;

        @RequestMapping("/index")
        public Object toIndex() {
                ProcessInstance pi = runtimeService.startProcessInstanceById("entryPipeApplication:1:4");
                System.out.print(pi.getStartTime());
                return userService.getUsers("lixiang");
        }
}
