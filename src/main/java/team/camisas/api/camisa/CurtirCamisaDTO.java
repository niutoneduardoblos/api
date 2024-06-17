package team.camisas.api.camisa;

import jakarta.validation.constraints.NotNull;

public record CurtirCamisaDTO(
        @NotNull 
        Long id,
        Long curtidas) {

}
