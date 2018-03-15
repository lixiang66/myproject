package com.hunter.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hunter.bean.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lixiang on 2018/3/15.
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

        List<User> selectAllByUsername(String username);

}
