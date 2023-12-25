package com.br.ebatista.springboot.service;

import com.br.ebatista.springboot.domain.user.User;
import com.br.ebatista.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public UserDetails findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public User save(User user) {
        return repository.save(user);
    }
}
