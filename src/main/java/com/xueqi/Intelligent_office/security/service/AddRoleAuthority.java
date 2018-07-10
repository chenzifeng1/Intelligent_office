package com.xueqi.Intelligent_office.security.service;

import com.xueqi.Intelligent_office.security.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


public class AddRoleAuthority {

    private final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;


    public void addRoleAuthorityTo(
            AuthorityName authorityName,
            String userName,
            String password) {
        System.out.println("authorityName:"+authorityName);
        System.out.println("userName:"+userName);
        System.out.println("password:"+password);
        if (authorityName==null||userName.isEmpty()||password.isEmpty()){
            log.debug("authorityName:"+authorityName);
            log.debug("userName:"+userName);
            log.debug("password:"+password);
        }else {
            Authority authority = null;
            try {
               authority = authorityRepository.findFirstByName(authorityName);
            }catch (NullPointerException e){
                if (authority==null){
                    authority = new Authority();
                    authority.setName(authorityName);
                    authorityRepository.save(authority);
                }
            }
            User user = userRepository.findFirstByUsername(userName);
            if (user==null){
                user = new User();
                user.setUsername(userName);
                user.setPassword(new BCryptPasswordEncoder().encode(password));
                userRepository.save(user);
            }
        }
    }
}
