package ru.vasyukma.todo.service.security;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.vasyukma.todo.model.security.AuthUser;
import ru.vasyukma.todo.repository.security.AuthUserRepository;
import ru.vasyukma.todo.security.CustomUserDetails;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthUserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication");
        AuthUser authUser = userRepository.findAuthUserByUsername(username).orElseThrow(s);
        return new CustomUserDetails(authUser);
    }
}
