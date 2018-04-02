package com.xueqi.Intelligent_office.jwt;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    /**
     * 提供一种从用户名可以查到用户并返回的方法【本系统使用手机号account进行唯一用户验证】
     * @param account
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

//        /**TODO:此处需要写明从用户表里面跟根据用户account查询用户的方法**/
//        User user =new User();
//        user.setAccount("17319237587");
//        user.setPwd("123");
//        user.setUserId(1L);
//        List<String> roles=new ArrayList<>();
//        roles.add("ADMIN");
//        user.setRoles(roles);
//        return JwtUserFactory.create(user);
        return null;
    }
}
