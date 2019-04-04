package com.qq.weixin.conf;

import com.qq.weixin.filter.AccessFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FilterConfig：
 * 2019/4/4 5:36
 * by kzm
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AccessFilter());
        registration.addUrlPatterns("/*");
        registration.setName("AccessFilter");
        registration.setOrder(1);
        return registration;
    }

}