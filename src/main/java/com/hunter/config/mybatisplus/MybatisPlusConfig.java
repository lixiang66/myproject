package com.hunter.config.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lixiang on 2018/3/15.
 */
@Configuration
@MapperScan("com.hunter.mapper")
public class MybatisPlusConfig {
        /*
         * 分页插件，自动识别数据库类型
         * 多租户，请参考官网【插件扩展】
         */
//        @Bean
//        public PaginationInterceptor paginationInterceptor() {
//                return new PaginationInterceptor();
//        }

   /*
    * oracle数据库配置JdbcTypeForNull
    * 参考：https://gitee.com/baomidou/mybatisplus-boot-starter/issues/IHS8X
    不需要这样配置了，参考 yml:
    mybatis-plus:
      confuguration
        dbc-type-for-null: 'null'
   @Bean
   public ConfigurationCustomizer configurationCustomizer(){
       return new MybatisPlusCustomizers();
   }

   class MybatisPlusCustomizers implements ConfigurationCustomizer {

       @Override
       public void customize(org.apache.ibatis.session.Configuration configuration) {
           configuration.setJdbcTypeForNull(JdbcType.NULL);
       }
   }
   */
}
