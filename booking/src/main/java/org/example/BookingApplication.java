package org.example;

import org.example.model.UserRole;
import org.example.model.UserAccount;
import org.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BookingApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(BookingApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.addRole(new UserRole(null, "ROLE_USER"));
//            userService.addRole(new UserRole(null, "ROLE_ADMIN"));
//
//            userService.addUser(new UserAccount(null, "Minh Quan", "minhquan", "1234", new ArrayList<>()));
//            userService.addUser(new UserAccount(null, "Minh Hien", "minhhien", "1234", new ArrayList<>()));
//            userService.addUser(new UserAccount(null, "Le Anh", "leanh", "1234", new ArrayList<>()));
//
//            userService.addRoleToUser("minhquan", "ROLE_USER");
//            userService.addRoleToUser("leanh", "ROLE_USER");
//            userService.addRoleToUser("leanh", "ROLE_ADMIN");
//        };
//    }
}
