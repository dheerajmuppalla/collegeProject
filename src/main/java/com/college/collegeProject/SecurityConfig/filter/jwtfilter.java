package com.college.collegeProject.SecurityConfig.filter;

import com.college.collegeProject.SecurityConfig.User_detail_service;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class jwtfilter extends OncePerRequestFilter {


    @Autowired
    jwtservice service;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authheader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if(authheader != null && authheader.startsWith("Bearer ")){
            token = authheader.substring(7);
            username = service.extractUserName(token);

        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails user = context.getBean(User_detail_service.class).loadUserByUsername(username);
            if(service.validateToken(token,user)){
                UsernamePasswordAuthenticationToken filter = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                filter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(filter);
            }


        }
        filterChain.doFilter(request,response);
    }
}
