package clone.inflearn.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // 1. CSRF 비활성화 (API 서버 만들 때 필수)
            .formLogin(AbstractHttpConfigurer::disable) // 2. 기본 로그인 폼 비활성화 (미사용)
            .httpBasic(AbstractHttpConfigurer::disable) // 3. HTTP Basic 인증 비활성화 (브라우저 팝업 방지)
            // .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // 4. 모든 요청 허용 (Permit All)
            .oauth2Login(Customizer.withDefaults()); // OAuth2 로그인 인증 요구

        return http.build();
    }
}