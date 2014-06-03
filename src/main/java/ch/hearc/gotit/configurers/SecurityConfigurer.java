package ch.hearc.gotit.configurers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
			.authoritiesByUsernameQuery("SELECT username, role FROM users, authorities"
					+ " WHERE users.username = ? AND users.fk_authority = authorities.pk_authority");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// XXX Keep or clean
		http.authorizeRequests()
				.antMatchers("/admin**").access("hasRole('admin')")
				.antMatchers("/users/sign-in**").anonymous()
			.and()
				.formLogin()
				.loginPage("/users/sign-in")
				.loginProcessingUrl("/users/sign-in")
				.defaultSuccessUrl("/", false)
				.failureUrl("/users/sign-in?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				// TODO enable (add checkbox at form)
//			.and()
//				.rememberMe()
//				.key("GotItKey")
//				.tokenValiditySeconds(86400)
			.and()
				.logout()
				.logoutUrl("/users/sign-out")
				.logoutSuccessUrl("/?sign-out") // XXX would be better "sign-out?success", but URLs conflicts
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/403")
			.and()
				.csrf().disable(); // TODO enable
	}
}
