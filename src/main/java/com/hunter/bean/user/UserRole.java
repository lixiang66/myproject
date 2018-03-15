package com.hunter.bean.user;

import javax.persistence.*;

/**
 * Created by lixiang on 2018/3/13.
 */
@Entity(name = "t_user_role")
@Table(indexes = @Index(name = "t_user_role_uid", columnList = "uid"))
public class UserRole {
        @Id
        @GeneratedValue
        private Integer id;

        private String uid;

        private Integer rid;

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

        public String getUid() {

                return uid;
        }

        public void setUid(String uid) {
                this.uid = uid;
        }
}
