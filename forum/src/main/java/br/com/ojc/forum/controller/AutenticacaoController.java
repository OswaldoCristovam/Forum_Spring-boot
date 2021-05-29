package br.com.ojc.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ojc.forum.config.security.TokenService;
import br.com.ojc.forum.controller.dto.TokenDto;
import br.com.ojc.forum.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
