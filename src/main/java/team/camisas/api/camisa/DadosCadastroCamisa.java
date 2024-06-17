package team.camisas.api.camisa;

import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import team.camisas.api.usuario.DadosCadastroUsuario;

public record DadosCadastroCamisa(
        @NotBlank
        String time,
        @NotNull
        Integer ano,
        @NotNull
        Tamanho tamanho,
        @NotNull
        Estado estado,
        @NotNull
        Integer curtidas,
        Date dataVersao) {

}
