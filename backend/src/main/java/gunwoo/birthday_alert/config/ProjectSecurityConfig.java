////package gunwoo.birthday_alert;
////
////import jakarta.servlet.http.HttpServletRequest;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.web.cors.CorsConfiguration;
////import org.springframework.web.cors.CorsConfigurationSource;
////
////import java.util.Collections;
////
////@Configuration
////public class ProjectSecurityConfig {
////    @Bean
////    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
////                    @Override
////                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
////                        CorsConfiguration config = new CorsConfiguration();
////                        config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
////                        config.setAllowedMethods(Collections.singletonList("*"));
////                        config.setAllowCredentials(true);
////                        config.setAllowedHeaders(Collections.singletonList("*"));
////                        config.setMaxAge(3600L); //1시간
////                        return config;
////                    }
////                }))
////                .authorizeHttpRequests((requests) -> requests
////                        .requestMatchers("/**").permitAll())
////                .formLogin(Customizer.withDefaults())
////                .httpBasic(Customizer.withDefaults())
////                .build();
////    }
////}
//package gunwoo.birthday_alert.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Collections;
//
//@Configuration
//public class ProjectSecurityConfig {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
//                    @Override
//                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                        CorsConfiguration config = new CorsConfiguration();
//                        config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//                        config.setAllowedMethods(Collections.singletonList("*"));
//                        config.setAllowCredentials(true);
//                        config.setAllowedHeaders(Collections.singletonList("*"));
//                        config.setMaxAge(3600L); // 1 hour
//                        return config;
//                    }
//                }))
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/**").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//        // Configure CSRF
//        http.csrf(csrf -> csrf.ignoringRequestMatchers("/**"));
//
//        return http.build();
//    }
//}


