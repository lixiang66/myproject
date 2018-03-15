package com.hunter.config.mvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiang on 2018/3/13.
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                //定义一个转换消息的对象
                FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
                //添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
                FastJsonConfig fastJsonConfig = new FastJsonConfig();
                fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
                List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
                fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);
                fastConverter.setSupportedMediaTypes(fastMedisTypes);
                //在转换器中添加配置信息
                fastConverter.setFastJsonConfig(fastJsonConfig);
                //将转换器添加到converters中
                converters.add(fastConverter);
        }
}
