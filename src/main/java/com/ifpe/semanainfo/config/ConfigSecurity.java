package com.ifpe.semanainfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ifpe.semanainfo.security.AppUserDetailsService;

@EnableWebSecurity
@ComponentScan(basePackageClasses = AppUserDetailsService.class)

public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppUserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	/*
	 * Metodo
	 * faz com que o spring ignore tudo que é passado no seu corpo
	 * ex. o spring security vai deixar a pasta assets ser acessadas por todos
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		 .antMatchers("/assets/**");
	}
	
	
	/*
	 * Metódo
	 * Faz o controle de permissões que podem ou não ser acessadoas
	 * por todos ou só por um usuário logado com as devidas permissões
	 * tabem há uma controle de o usuario logar apenas uma vez */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()	
			    .antMatchers("/admin/novo").hasRole("CADASTRAR_GESTOR")
			    .antMatchers("/admin").hasRole("LISTAR_GESTOR")
				.anyRequest().authenticated()	
			    //.anyRequest().denyAll()
				.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			    .and()
			   .logout()
			      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.and()
				.exceptionHandling().accessDeniedPage("/403")
		      .and()
		      .sessionManagement()
		           .maximumSessions(1)
		           .expiredUrl("/multiple")
		          .and()
		          .invalidSessionUrl("/login");
		        
				
	}
	
	/*
	 * Metódo
	 * resposável por encriptar senhas*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}