package ru.vasyukma.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ru.vasyukma.todo.service.security.JpaUserDetailsService;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {
    
    @Autowired
    private JpaUserDetailsService jpaUserDetailsSerive;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SCryptPasswordEncoder sCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        CustomUserDetails customUserDetails = jpaUserDetailsSerive.loadUserByUsername(username);
        switch (customUserDetails.getAuthUser().getAlgorithm()) {
            case BCRYPT:
                return checkPassword(customUserDetails, password, bCryptPasswordEncoder);
            case SCRYPT:
                return checkPassword(customUserDetails, password, sCryptPasswordEncoder);
        }
        throw new BadCredentialsException("Bad credantials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private Authentication checkPassword(CustomUserDetails user, String rawPassword, PasswordEncoder passwordEncoder) {
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user
                    .getAuthorities());
        } else {
            throw new BadCredentialsException("Bad credentioals");
        }
    }
}
