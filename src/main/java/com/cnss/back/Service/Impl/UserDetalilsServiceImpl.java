package com.cnss.back.Service.Impl;

import com.cnss.back.Entity.User;
import com.cnss.back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetalilsServiceImpl  implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null) throw new UsernameNotFoundException("invalid user");
        if(user.getIsEnabled().equals(false)) {
            throw new RuntimeException("User "+username+" is disabled");
        }
        if(user.getIsDeleted().equals(true)) {
            throw new RuntimeException("User "+username+" is deleted");
        }
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority().getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
