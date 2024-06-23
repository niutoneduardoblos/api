package team.camisas.api.infra.exception;

import org.springframework.validation.FieldError;

public record DadosErrosValidacaoDTO(String campo, String mensagem) {

    public DadosErrosValidacaoDTO(FieldError erro){
        this(erro.getField(),erro.getDefaultMessage());
    }
}
