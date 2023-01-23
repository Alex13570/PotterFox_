package ru.loonolud.potterfox_.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.loonolud.potterfox_.exceptions.user.UserNotFoundException;
import ru.loonolud.potterfox_.model.UserDetailsEntity;
import ru.loonolud.potterfox_.repositiry.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsEntity user = userRepository.findByEmail(username).orElseThrow(() -> {throw new UserNotFoundException();});
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword().toString())
                .roles(user.getRole().toString())
                .build();
    }
}
