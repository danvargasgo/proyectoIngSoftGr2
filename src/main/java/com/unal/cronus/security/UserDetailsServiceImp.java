package com.unal.cronus.security;

import com.unal.cronus.model.entitity.User;
import com.unal.cronus.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> ouser = userRepository.findById(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder =null;
        if(ouser.isEmpty()){
            throw new UsernameNotFoundException("usuario no encontrado");

        }
        else {
            User user = ouser.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(false);
            builder.password(user.getPassword());
            String role = user.getTypeUser().toString();
            builder.authorities(new SimpleGrantedAuthority(role));
        }
        return builder.build();
    }
}
