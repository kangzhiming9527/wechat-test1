package com.qq.weixin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * AccessFilter：
 * 2019/4/4 5:32
 * by kzm
 */
public class AccessFilter implements Filter {
    Logger log = LoggerFactory.getLogger(AccessFilter.class);
    private static List<String> ips;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        ips = AacquireServerIPS.getServerIP();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String url = request.getRequestURI();
//
//        System.out.println("请求的url：" + url);
//        /*登录页面不需要过滤*/
//
//        int idx = url.lastIndexOf("/");
//        String endWith = url.substring(idx + 1);

//        if (null == ips) {
//            ips = AacquireServerIPS.getServerIP();
//        }
//        String ipAddress = CusAccessObjectUtil.getIpAddress((HttpServletRequest) servletRequest);
//        log.debug("访问IP为:" + ipAddress);
//        if (ips!=null&&ips.contains(ipAddress)) {
//            log.debug("访问IP来自服务器");
        filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            log.warn("非法访问，访问IP不是来自服务器，请求已拦截\t非法访问IP："+ipAddress);
//        }

    }

    @Override
    public void destroy() {

    }
}
