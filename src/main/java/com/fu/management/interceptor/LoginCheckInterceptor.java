package com.fu.management.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fu.management.pojo.Result;
import com.fu.management.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截非登录请求");
        String jwt = request.getHeader("token");
        if (StringUtils.hasLength(jwt)) {
            try {
                JwtUtils.parseJwt(jwt);
                log.info("请求放行");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info("令牌解析失败或不存在");
        Result error = Result.error("NOT_LOGIN");
        ObjectMapper mapper = new ObjectMapper();
        String errorJson = mapper.writeValueAsString(error);
        response.getWriter().write(errorJson);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
