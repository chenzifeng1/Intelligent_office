package com.xueqi.Intelligent_office.security.config;

import com.xueqi.Intelligent_office.security.model.*;
import com.xueqi.Intelligent_office.security.service.AddRoleAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DevConfig {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @PostConstruct
    public void adddevUserAndAuthority(){
        Authority authority = authorityRepository.findFirstByName(AuthorityName.ROLE_USER);
        /**为devUser增加角色和权限**/
        if (authority==null){
            authority= new Authority();
            authority.setName(AuthorityName.ROLE_USER);
            authorityRepository.save(authority);
        }
        User user = userRepository.findFirstByUsername("dev");
        if (user ==null){
            user = new User();
            user.setUsername("dev");
            user.setPassword(new BCryptPasswordEncoder().encode("dev"));
            user.addAuthorty(authority);
            userRepository.save(user);
        }
    }

    @PostConstruct
    public void addDepartmentAuthority(){
        Authority authority = authorityRepository.findFirstByName(AuthorityName.ROLE_DEPARTMENT);
        if (authority==null){
            authority = new Authority();
            authority.setName(AuthorityName.ROLE_DEPARTMENT);
            authorityRepository.save(authority);
        }
        User user = userRepository.findFirstByUsername("department");
        if (user ==null){
            user = new User();
            user.setUsername("department");
            user.setPassword(new BCryptPasswordEncoder().encode("department"));
            user.addAuthorty(authority);
            userRepository.save(user);
        }
    }
//
//    @PostConstruct
//    public void addAdminUserAuthority(){
//        AddRoleAuthority addRoleAuthority = new AddRoleAuthority();
//        addRoleAuthority.addRoleAuthorityTo(AuthorityName.ROLE_ADMIN,
//                "admin",
//                "admin");
//    }
}