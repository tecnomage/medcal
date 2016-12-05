package br.com.medclin.confs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.medclin.boot.daos.UsuarioDao;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDao usuariodao;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests().antMatchers("/").permitAll()
//		.antMatchers("/medclin/home").hasAnyRole("ADMIN")
//		.antMatchers("/medclin/pacientes/**").permitAll()
//		.antMatchers("css/**").permitAll()
//		.antMatchers("templates/**").permitAll()
//		.and().formLogin();
//
//	}
	
	protected void configure(HttpSecurity http) throws Exception 
	{	
	http
    .authorizeRequests()
        .antMatchers("/", "/medclin/**","/medclin/login").permitAll()
        .and()
    .formLogin()
        .loginPage("medclin/login")
        .permitAll()
        .and()
    .logout()
        .permitAll();
}
//	 @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth
//	            .inMemoryAuthentication()
//	                .withUser("user").password("pass").roles("ADMIN");
//	    }
//	
//	 @Autowired
//	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth
//	            .inMemoryAuthentication()
//	                .withUser("user").password("pass").roles("ADMIN");
//	    }

	 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuariodao);
		 //.passwordEncoder(new BCryptPasswordEncoder()
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuariodao);
		
	}





}


