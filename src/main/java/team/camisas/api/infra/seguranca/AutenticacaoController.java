package team.camisas.api.infra.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import team.camisas.api.domain.usuario.DadosAutenticacaoDTO;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacaoDTO dadosAutenticacaoDTO) {

        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacaoDTO.email(), dadosAutenticacaoDTO.senha());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();

    }
}