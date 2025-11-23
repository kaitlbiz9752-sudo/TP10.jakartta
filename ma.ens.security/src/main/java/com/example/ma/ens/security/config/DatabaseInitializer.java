package com.example.ma.ens.security.config;

import com.example.ma.ens.security.entities.Role;
import com.example.ma.ens.security.entities.User;
import com.example.ma.ens.security.repositories.RoleRepository;
import com.example.ma.ens.security.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepo,
                           UserRepository userRepo,
                           PasswordEncoder encoder) {

        return args -> {

            if (roleRepo.count() == 0) {

                Role adminRole = roleRepo.save(new Role(null, "ROLE_ADMIN"));
                Role userRole = roleRepo.save(new Role(null, "ROLE_USER"));

                User admin = new User(
                        null, "admin",
                        encoder.encode("1234"),
                        true,
                        List.of(adminRole, userRole)
                );

                User user = new User(
                        null, "user",
                        encoder.encode("1111"),
                        true,
                        List.of(userRole)
                );

                userRepo.saveAll(List.of(admin, user));
            }
        };
    }
}
