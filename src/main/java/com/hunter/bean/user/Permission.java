package com.hunter.bean.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by lixiang on 2018/3/13.
 */
@Entity(name = "t_permission")
@Table(uniqueConstraints = @UniqueConstraint(name = "t_permission_permission", columnNames = "permission"))
public class Permission implements GrantedAuthority {

        @Id
        private Integer id;
        private String permission;
        private String status;
        private String desc1;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getPermission() {
                return permission;
        }

        public void setPermission(String permission) {
                this.permission = permission;
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
                return permission;
        }
}
