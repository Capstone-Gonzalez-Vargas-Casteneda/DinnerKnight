package com.example.dinnerknight.services;


import com.example.dinnerknight.models.User;
import com.example.dinnerknight.models.UserWithRoles;
import com.example.dinnerknight.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepository userDao;

    public UserDetailsLoader(UserRepository userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userDao.findByUsername(username);
        if( user == null){
            throw new UsernameNotFoundException("No User found by: " + username);
        }
        return new UserWithRoles(user);
    }
}
