package com.hunter.config.security;

import com.hunter.propertis.ApplicaitonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by lixiang on 2018/3/13.
 */
@Configuration
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

        private final static String loginPAGE = "/auth/login";
        private final static String loginURL = "/auth/form";
        private final static String logoutURL = "/auth/logout";
        private final static String loginSUCCESS = "/auth/success";
        @Autowired
        private ApplicaitonProperties applicaitonProperties;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                //路径权限控制
                http.authorizeRequests()
                        .antMatchers(
                                applicaitonProperties.getLoginUrl(),
                                applicaitonProperties.getLogoutRedirect(),
                                loginPAGE, loginURL, logoutURL
                        ).permitAll()
                        .antMatchers("/admin/**", "/admin**").hasRole("ADMIN")
                        .antMatchers("/user/**", "/user**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated();
                //表单登录
                http.formLogin().usernameParameter("username").passwordParameter("password")
                        .loginPage(loginPAGE).loginProcessingUrl(loginURL).defaultSuccessUrl(loginSUCCESS)
                        .and().logout().logoutUrl(logoutURL).logoutSuccessUrl(applicaitonProperties.getLogoutRedirect());
                //记住我
                http.rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(7 * 24 * 60 * 60);

                //session控制
                http.sessionManagement().maximumSessions(1)
                        .maxSessionsPreventsLogin(false)
                        .expiredSessionStrategy(new SessionInformationExpiredStrategyImpl(loginPAGE));

                //跨域
                http.csrf().disable();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
                super.configure(web);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(getUserDetailsService())
                        .passwordEncoder(getPasswordEncoder());
        }

        @Bean
        public UserDetailsService getUserDetailsService() {
                return new UserDetailServiceImpl();
        }

        @Bean
        public PasswordEncoder getPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

}
