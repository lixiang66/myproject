package com.hunter.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lixiang on 2018/3/14.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

        @GetMapping("/index")
        public Object index() {
                if (true) {
                        throw new RuntimeException("xxxx");
                }
                return "管理员首页！";
        }
}
