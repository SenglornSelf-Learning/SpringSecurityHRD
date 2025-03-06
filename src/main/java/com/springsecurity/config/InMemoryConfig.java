package com.springsecurity.config;

//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
public class InMemoryConfig {
//    private final PasswordEncoder passwordEncoder;

    /* In Memory Configuration */
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails user = User
//                .builder()
//                .username("user")
//                .password(passwordEncoder.encode("321"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//
//        System.out.println(admin.getPassword());
//        return new InMemoryUserDetailsManager(user, admin);
//    }


    /* In Database Configuration */
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/user").hasRole("USER")
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .requestMatchers("/all").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/bye", "/user/**").permitAll()   // ** meaning that ok with everything in front of it
//                        .anyRequest()
//                        .authenticated()
//                )
//                .formLogin().defaultSuccessUrl("/welcome", true)
//                .and()
//                .httpBasic()
//        ;
//        return http.build();
//    }
}
