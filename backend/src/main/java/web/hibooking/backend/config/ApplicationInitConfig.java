package web.hibooking.backend.config;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import web.hibooking.backend.entities.Role;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.enums.RoleEnum;
import web.hibooking.backend.repository.RoleRepository;
import web.hibooking.backend.repository.UserRepository;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

//    @Bean
//    ApplicationRunner applicationRunner(UserRepository userRepository){
//        return args -> {
//            if (!userRepository.existsByEmail("admin@gmail.com")) {
//                // Fetch the Role entity using a managed method
//                Set<Role> adminRole = roleRepository.findRoleByName(RoleEnum.ADMIN.name());
//
//                User user = User.builder()
//                        .email("admin@gmail.com")
//                        .password(passwordEncoder.encode("admin"))
//                        .roles(adminRole) // Ensure it's a Set of Role entities
//                        .build();
//
//                userRepository.save(user);
//                log.warn("Admin user has been created with default password: admin, please change it");
//            }
//
//        };
//    }
}
