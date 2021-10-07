package com.empowerenergy.empowerenergy.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //pra informar que essa classe ativa a config da segurança
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Auto
	
}
