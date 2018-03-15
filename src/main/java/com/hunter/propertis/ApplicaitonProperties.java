package com.hunter.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lixiang on 2018/3/13.
 */
@ConfigurationProperties(prefix = "application.hunter")
public class ApplicaitonProperties {

        private String loginUrl;

        private String logoutRedirect;

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
