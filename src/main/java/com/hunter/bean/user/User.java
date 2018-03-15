package com.hunter.bean.user;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lixiang on 2018/3/13.
 */
@Entity(name = "t_user")
public class User implements UserDetails {
        @Id
        private String username;
        @JSONField(serialize = false)
        private String password;
        private String phone;
        private String email;
        private String dept;
        private String status;

        @Transient
        @JSONField(serialize = false)
        private Set<Role> roles;
        @Transient
        @JSONField(serialize = false)
        private Set<Permission> permissions;

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getDept() {
                return dept;
        }

        public void setDept(String dept) {
                this.dept = dept;
        }

        public Set<Permission> getPermissions() {
                return permissions;
        }

        public void setPermissions(Set<Permission> permissions) {
                this.permissions = permissions;
        }

        public Set<Role> getRoles() {
                return roles;
        }

        public void setRoles(Set<Role> roles) {
                this.roles = roles;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                User user = (User) o;

                return username != null ? username.equals(user.username) : user.username == null;
        }

        @Override
        public int hashCode() {
                return username != null ? username.hashCode() : 0;
        }

        @Override
        @JSONField(serialize = false)
        public Collection<? extends GrantedAuthority> getAuthorities() {
                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.addAll(roles);
                authorities.addAll(permissions);
                return authorities;
        }

        @Override
        @JSONField(serialize = false)
        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        @Override
        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        @Override
        @JSONField(serialize = false)
        public boolean isAccountNonExpired() {
                return !"1".equals(getStatus());
        }

        @Override
        @JSONField(serialize = false)
        public boolean isAccountNonLocked() {
                return !"2".equals(getStatus());
        }

        @Override
        @JSONField(serialize = false)
        public boolean isCredentialsNonExpired() {
                return !"3".equals(getStatus());
        }

        @Override
        @JSONField(serialize = false)
        public boolean isEnabled() {
                return !"4".equals(getStatus());
        }
}
