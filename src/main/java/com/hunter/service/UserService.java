package com.hunter.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunter.bean.user.User;
import com.hunter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lixiang on 2018/3/15.
 */
@Service
public class UserService {
        @Autowired
        UserMapper userMapper;

        @Cacheable(value = "cache.user", key = "#username")
        public PageInfo<User> getUsers(String username) {
                PageHelper.startPage(1, 10);
                List<User> list = userMapper.selectAllByUsername(username);
                PageInfo<User> info = new PageInfo<>(list);
                return info;
        }
}
