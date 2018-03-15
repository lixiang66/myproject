package com.hunter.config.security;

import com.google.common.collect.Sets;
import com.hunter.bean.user.Permission;
import com.hunter.bean.user.Role;
import com.hunter.bean.user.User;
import com.hunter.repositories.PermissionRepository;
import com.hunter.repositories.RoleRepository;
import com.hunter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by lixiang on 2018/3/13.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private RoleRepository roleRepository;
        @Autowired
        private PermissionRepository permissionRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                try {
                        User user = userRepository.findById(username).get();
                        user.setPassword(passwordEncoder.encode(user.getPassword()));
                        Set<Role> roles = roleRepository.findAllByUsername(user.getUsername());
                        user.setRoles(roles);

                        if (!roles.isEmpty()) {
                                Set<Integer> ids = Sets.newHashSet();
                                for (Role role : roles) {
                                        ids.add(role.getId());
                                }
                                Set<Permission> permissions = permissionRepository.findAllByRoleId(ids);
                                user.setPermissions(permissions);
                        }

                        return user;
                } catch (NoSuchElementException e) {
                        throw new UsernameNotFoundException("用户不存在！");
                }

        }
}
