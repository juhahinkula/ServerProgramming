package fi.haagahelia.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/css/**").permitAll() // Enable css when logged out
				.anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/studentlist", true).permitAll()
				.and().logout().permitAll().and().httpBasic();
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		System.out.println("in-memory users - luodaan näitä kaksi kappaletta");
		List<UserDetails> users = new ArrayList<UserDetails>();

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user1 = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();

		users.add(user1);

		UserDetails user2 = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN")
				.build();

		users.add(user2);

		return new InMemoryUserDetailsManager(users);
	}
}
