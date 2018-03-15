package com.hunter.bean.user;

import javax.persistence.*;

/**
 * Created by lixiang on 2018/3/13.
 */
@Entity(name = "t_role_permission")
@Table(indexes = @Index(name = "t_role_permission_rid", columnList = "rid"))
public class RolePermission {
        @Id
        @GeneratedValue
        private Integer id;

        private Integer rid;

        private Integer pid;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Integer getRid() {
                return rid;
        }

        public void setRid(Integer rid) {
                this.rid = rid;
        }

        public Integer getPid() {

                return pid;
        }

        public void setPid(Integer pid) {
                this.pid = pid;
        }
}
