package com.ifpe.semanainfo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.Users;

@Service
public class AppUserDetailsService implements UserDetailsService {
 
	@Autowired
	private Users usersRpository;
	
	
	/*
	 * Metodo
	 * Buscar e/ou carrega um usuario pelo email
	 * tambem pega atraves de herança os dados do usuario logado*/
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserModel> userOptional = usersRpository.findByEmailIgnoreCaseAndActiveTrue(email);		
		UserModel userMod = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));		
		return new SystemUser(userMod, getPermissions(userMod));
	}


	/*metodo
	 * pega alista das permissões que estão no banco de dados*/
	
	private Collection<? extends GrantedAuthority> getPermissions(UserModel userMod) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		List<String> permissions = usersRpository.permissions(userMod);
		permissions.forEach(p -> authorities.add(new SimpleGrantedAuthority("ROLE_" +p.toUpperCase())));
		
		return authorities;
	}

}
