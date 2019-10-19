package cn.ltx.activiti7.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
/**
 * 添加拦截器
 */
public class SessionConfiguration implements WebMvcConfigurer {
    @Resource
    private SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry ){
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
        //网站配置生成器：添加一个拦截器，拦截路径为整个项目
    }
}