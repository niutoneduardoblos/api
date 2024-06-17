package team.camisas.api.usuario;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
    @NotBlank
    String nome,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String senha,
    Boolean ativo,
    Boolean administrador,
    Date dataVersao) {

}
