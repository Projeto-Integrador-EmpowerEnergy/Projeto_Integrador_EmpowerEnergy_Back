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

	public UsuarioModel CadastrarUsuario(UsuarioModel nomeUsuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(nomeUsuario.getSenhaUsuario());
        nomeUsuario.setSenhaUsuario(senhaEncoder);
		
		return repository.save(nomeUsuario);

	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<UsuarioModel> nomeUsuario = repository.findByNomeUsuario(user.get().getNome());

        if(nomeUsuario.isPresent()){
            if(encoder.matches(user.get().getSenha(), nomeUsuario.get().getSenhaUsuario())) {
                String auth = user.get().getNome() + ":" + user.get().getSenha();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);

                user.get().setToken(authHeader);
                user.get().setNome(nomeUsuario.get().getNomeUsuario());
                user.get().setId(nomeUsuario.get().getIdUsuario());
                user.get().setSenha(nomeUsuario.get().getSenhaUsuario());
                user.get().setUsuario(nomeUsuario.get().getEmailUsuario());

                return user;
            }
        }
        return null;
	}
}
