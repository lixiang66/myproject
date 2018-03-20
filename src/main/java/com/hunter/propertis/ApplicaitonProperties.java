package com.hunter.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lixiang on 2018/3/13.
 */
@ConfigurationProperties(prefix = "application.hunter")
public class ApplicaitonProperties {

        private String loginUrl;

        private String logoutRedirect;
        private Integer uploadSize;

        public Integer getUploadSize() {
                return uploadSize;
        }

        public void setUploadSize(Integer uploadSize) {
                this.uploadSize = uploadSize;
        }

        public String getLoginUrl() {
                return loginUrl;
        }

        public void setLoginUrl(String loginUrl) {
                this.loginUrl = loginUrl;
        }

        public String getLogoutRedirect() {
                return logoutRedirect;
        }

        public void setLogoutRedirect(String logoutRedirect) {
                this.logoutRedirect = logoutRedirect;
        }
}
