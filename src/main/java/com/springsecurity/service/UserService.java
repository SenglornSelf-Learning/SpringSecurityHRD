package com.springsecurity.service;

import com.springsecurity.entity.AppUser;
import com.springsecurity.entity.AppUserDTO;
import com.springsecurity.entity.AppUserRequest;
import com.springsecurity.repository.UserRepository;
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
        AppUser user = userRepository.findUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    public AppUserDTO insertUser(AppUserRequest appUserRequest) {
        String hashedPassword = passwordEncoder.encode(appUserRequest.getPassword());

        AppUser appUser = new AppUser();
        appUser.setName(appUserRequest.getName());
        appUser.setEmail(appUserRequest.getEmail());
        appUser.setPassword(hashedPassword);
        appUser.setRole(appUserRequest.getRole());

        userRepository.insertUser(appUser);

        return new AppUserDTO(appUser.getId(), appUser.getName(), appUser.getEmail(), appUser.getRole());
    }
}
