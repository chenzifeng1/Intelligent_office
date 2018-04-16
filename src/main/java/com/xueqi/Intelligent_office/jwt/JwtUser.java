//package com.xueqi.Intelligent_office.jwt;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class JwtUser implements UserDetails {
//    private final Long id;
//    private final String username; //设置为account
//    private final String password;
//    private final Collection<? extends GrantedAuthority> authorities;
//
//    public JwtUser(Long id, String username, String password,  Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    /**
//     * 返回分配给用户的角色列表
//     * @return
//     */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    /**
//     * 账户是否未过期
//     * @return
//     */
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    /**
//     * 账户是否未锁定
//     * @return
//     */
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    /**
//     * 密码是否未过期
//     * @return
//     */
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    /**
//     * 账户是否激活
//     * @return
//     */
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
