package team.camisas.api.camisa;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCamisaDTO(
        @NotBlank
        String time,
        @NotNull
        Long ano,
        @NotNull
        Tamanho tamanho,
        @NotNull
        Estado estado,
        @NotNull
        Long curtidas,
        Date dataVersao,
        Long idUsuario) {

}
