package com.yhc.example.zguide.auth.server.server;
import com.yhc.example.zguide.auth.server.dto.AuthAccount;
import com.yhc.example.zguide.auth.server.user.modle.UserAuthEntity;
import com.yhc.example.zguide.auth.server.user.server.UserAuthServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class BaseUserDetailService implements UserDetailsService {
    @Autowired
    private UserAuthServer userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthEntity account = userService.getUser(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定//
        account.setEnabled(enabled);
        account.setAccountNonExpired(accountNonExpired);
        account.setCredentialsNonExpired(credentialsNonExpired);
        account.setAccountNonLocked(accountNonLocked);
        UserDetails userDetails = getUserDetails(account);
        return userDetails;
    }


    private UserDetails getUserDetails(UserAuthEntity account) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        return new SysUser(account.getId(),
                account.getDeptId(),
                account.getTenantId(),
                account.getUsername(),
                account.getPassword(),
                account.isEnabled(),
                account.isAccountNonExpired(),
                account.isCredentialsNonExpired(),
                account.isAccountNonLocked(),
                authorities,account.getBtns());
    }
}
