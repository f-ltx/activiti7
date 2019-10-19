package cn.ltx.activiti7.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ltx.activiti7.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对某些接口进行放行
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("getContextPath:" + request.getContextPath());
        System.out.println("getServletPath:" + request.getServletPath());
        System.out.println("getRequestURI:" + request.getRequestURI());
        System.out.println("getRequestURL:" + request.getRequestURL());
        System.out.println("getRealPath:" + request.getSession().getServletContext().getRealPath("image"));
        //首页路径以及登录放行
        if ("/".equals(request.getRequestURI()) || "/error".equals(request.getRequestURI())) {
            return true;
        }
        //重定向
        User user = (User) request.getSession().getAttribute("user");
        if (null == user || null == user.getUserGuid()) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}