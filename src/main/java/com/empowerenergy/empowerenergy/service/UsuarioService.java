package com.empowerenergy.empowerenergy.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.empowerenergy.empowerenergy.model.UserLogin;
import com.empowerenergy.empowerenergy.model.UsuarioModel;
import com.empowerenergy.empowerenergy.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Object> CadastrarUsuario(UsuarioModel usuarioParaCadastrar) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return repository.findByEmailUsuario(usuarioParaCadastrar.getEmailUsuario()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			usuarioParaCadastrar.setSenhaUsuario(encoder.encode(usuarioParaCadastrar.getSenhaUsuario()));
			return Optional.ofNullable(repository.save(usuarioParaCadastrar));
		});

	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<UsuarioModel> optionalUsuario = repository.findByEmailUsuario(user.get().getEmail());

        if(optionalUsuario.isPresent()){
            if(encoder.matches(user.get().getSenha(), optionalUsuario.get().getSenhaUsuario())) {
                String auth = user.get().getEmail() + ":" + user.get().getSenha();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);

                user.get().setToken(authHeader);
                user.get().setNome(optionalUsuario.get().getNomeUsuario());
                user.get().setId(optionalUsuario.get().getIdUsuario());
                user.get().setSenha(optionalUsuario.get().getSenhaUsuario());
                user.get().setEmail(optionalUsuario.get().getEmailUsuario());
                user.get().setFoto(optionalUsuario.get().getFotoUsuario());
                user.get().setTipo(optionalUsuario.get().getTipoUsuario());

                return user;
            }
        }
        return null;
	}
}
