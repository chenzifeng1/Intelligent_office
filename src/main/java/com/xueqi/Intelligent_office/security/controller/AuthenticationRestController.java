package com.xueqi.Intelligent_office.security.controller;

import com.xueqi.Intelligent_office.dto.JsonMessage;
import com.xueqi.Intelligent_office.security.model.User;
import com.xueqi.Intelligent_office.security.model.UserRepository;
import com.xueqi.Intelligent_office.security.service.JwtAuthenticationResponse;
import com.xueqi.Intelligent_office.security.service.JwtTokenUtil;
import com.xueqi.Intelligent_office.security.service.JwtUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AuthenticationRestController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    private Log log = LogFactory.getLog(this.getClass());

    @PostMapping("/user/login")
    public Object createAuthenticationToken(String username, String password, Device device) throws   AuthenticationException{
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(password,userDetails.getPassword())==false){
            return new JsonMessage(-1,"the username or password is wrong");
        }
        final String token = jwtTokenUtil.generateToken((JwtUser) userDetails,device);
        log.debug("the token is :"+token);
        Map<Object,Object> objectMap = new HashMap<>();
        User user = userRepository.findFirstByUsername(userDetails.getUsername());
        objectMap.put("user",user);
        objectMap.put("token",token);
        return objectMap;
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken (HttpServletRequest request){
        String token = request.getHeader("jwtHeader");
        String username =jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if(jwtTokenUtil.canTokenBeRefreshed(token,user.getLastPasswordResetDate())){
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
