package com.empowerenergy.empowerenergy.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empowerenergy.empowerenergy.model.UsuarioModel;
import com.empowerenergy.empowerenergy.repository.UsuarioRepository;


@Service //é um serviço 
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByNomeUsuario(nomeUsuario);
		user.orElseThrow(() -> new UsernameNotFoundException(nomeUsuario + " Not Found."));
		
		return user.map(UserDetailsImpl::new).get();
	}
	
	
}
