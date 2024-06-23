package team.camisas.api.infra.seguranca;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import team.camisas.api.domain.usuario.UsuarioBean;

@Service
public class TokenService {

    @Value("${api.security.toke.secret}")
    private String secret;

    public String gerarToken(UsuarioBean usuarioBean) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);// Usar RSA no futuro
            return JWT.create()
                    .withIssuer("API colecao.camisas")
                    .withSubject(usuarioBean.getEmail())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
