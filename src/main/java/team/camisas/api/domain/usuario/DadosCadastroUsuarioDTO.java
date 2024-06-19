package team.camisas.api.domain.usuario;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuarioDTO(
    @NotBlank
    String nome,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String senha,
    Boolean ativo,
    Boolean administrador,
    Date dataVersao,
    Long idUsuario) {

}
