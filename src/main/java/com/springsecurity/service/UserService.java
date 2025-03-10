package com.springsecurity.service;

import com.springsecurity.model.AppUser;
import com.springsecurity.model.AppUserDTO;
import com.springsecurity.model.AppUserRequest;
import com.springsecurity.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    @Transactional
    public AppUserDTO insertUser(AppUserRequest appUserRequest) {
        String hashedPassword = passwordEncoder.encode(appUserRequest.getPassword());

        AppUser appUser = new AppUser();
        appUser.setName(appUserRequest.getName());
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setPassword(hashedPassword);
        appUser.setRole(appUserRequest.getRole());

        AppUser savedUser = userRepository.save(appUser);
        System.out.println("User saved with ID: " + savedUser.getId());

        return new AppUserDTO(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getRole());
    }
}
