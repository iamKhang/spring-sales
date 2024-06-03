package com.lehoangkhang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//	@Autowired
//	private CustomUserDetailService customUserDetailService;

	@Bean
	@SuppressWarnings("deprecation")
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeRequests(auth -> auth.requestMatchers("/*").permitAll().requestMatchers("/admin/**")
						.hasAuthority("Manager").anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/logon").loginProcessingUrl("/logon").usernameParameter("username")
						.passwordParameter("password").defaultSuccessUrl("/admin", true))
				.logout(logout -> logout.logoutUrl("/admin-logout").logoutSuccessUrl("/logon") );
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(
				"/assets/**", "/assetsUser/**"
				);
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
