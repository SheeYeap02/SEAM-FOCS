//package com.seam.focs.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.seam.focs.common.BaseContext;
//import com.seam.focs.common.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.AntPathMatcher;
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Check current user has been already logged-in
// */
//@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
//@Slf4j
//public class LoginCheckFilter implements Filter {
//    //Utils - Path Comparator/Matching, support wildcard also
//    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        // Get Current URI Request (Uniform Resource Identifier) - when identify/locate/access resources e.g. webpages
//        String requestURI = request.getRequestURI();
//        log.info("Request Caught: {}", requestURI);
//
//        //Paths that no need to handle
//        String[] urls = new String[] {
//                "/applicant/signup",
//                "/applicant/login",
//                "/applicant/logout",
//                "/dist/**",
//                "/common/**"
//        }; //If got admin site, add also
//
//        // Determine Whether Current Request Need To Be Handled
//        // If No, let it go
//        boolean check = checkHandlingNeed(urls, requestURI);
//        if(check) {
//            log.info("Current Request {} Don't Need To Handle", requestURI);
//
//            long id = Thread.currentThread().getId();
//            log.info("Thread id: {}", id);
//
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // Determine login status and if already login, let it go
//        if(request.getSession().getAttribute("applicant") != null) {
//            log.info("User Has Logged-in, User Id is: {}", request.getSession().getAttribute("applicant"));
//
//            Long apcId = (Long) request.getSession().getAttribute("applicant");
//            BaseContext.setCurrentId(apcId);
//
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // If user haven't login, return login result to client side
//        log.info("User Haven't Login");
//        response.setContentType("application/json");
//        response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
//
//        return;
//    }
//
//    /**
//     * Path Matching, check whether to directly pass/let go the current request
//     * @param urls
//     * @param requestURI
//     * @return
//     */
//    public boolean checkHandlingNeed(String[] urls, String requestURI) {
//        for (String url : urls) {
//            boolean match = PATH_MATCHER.match(url, requestURI);
//            if(match) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
