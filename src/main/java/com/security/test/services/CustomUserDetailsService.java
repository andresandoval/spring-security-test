package com.security.test.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by asandoval on 22/09/2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("admin_user") && !username.equals("other_user"))
            throw new UsernameNotFoundException("User " + username + "not found");
        return new User(username, "test_password", getGrantedAuthorities(username));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        Collection<? extends GrantedAuthority> authorities;
        if (username.equals("admin_user")) {
            authorities = Arrays.asList(() -> "ROLE_ADMIN");
        } else {
            authorities = Arrays.asList(() -> "ROLE_BASIC");
        }
        return authorities;
    }
}
