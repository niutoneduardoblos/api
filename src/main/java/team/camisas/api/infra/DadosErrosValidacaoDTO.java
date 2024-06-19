package team.camisas.api.infra;

import org.springframework.validation.FieldError;

public record DadosErrosValidacaoDTO(String campo, String mensagem) {

    public DadosErrosValidacaoDTO(FieldError erro){
        this(erro.getField(),erro.getDefaultMessage());
    }
}
