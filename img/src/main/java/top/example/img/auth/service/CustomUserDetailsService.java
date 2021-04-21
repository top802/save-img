package top.example.img.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import top.example.img.auth.model.Role;
import top.example.img.auth.model.User;
import top.example.img.auth.repository.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User with " + email + " not found" );
        } else if (!user.isEnabled()) {
            throw new DisabledException("Your account is not confirmed. Please check your e-mail " + email + " and click on confirmation link");
        }
        GrantedAuthority grantedAuthorities = new SimpleGrantedAuthority(user.getRole().getName());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), (Collection<? extends GrantedAuthority>) grantedAuthorities);
    }
}
