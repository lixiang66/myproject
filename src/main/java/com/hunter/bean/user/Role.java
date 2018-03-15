package com.hunter.bean.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by lixiang on 2018/3/13.
 */
@Entity(name = "t_role")
@Table(uniqueConstraints = @UniqueConstraint(name = "t_role_role", columnNames = "role"))
public class Role implements GrantedAuthority {
        @Id
        private Integer id;
        private String role;
        private String status;
        private String desc1;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getDesc1() {
                return desc1;
        }

        public void setDesc1(String desc1) {
                this.desc1 = desc1;
        }

        @Override
        public String getAuthority() {
                return role;
        }
}
