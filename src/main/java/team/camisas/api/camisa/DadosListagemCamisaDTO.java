package team.camisas.api.camisa;

public record DadosListagemCamisaDTO(String time, Long ano, Tamanho tamanho, Estado estado, Long curtidas) {

    public DadosListagemCamisaDTO(CamisaBean camisaBean) {
        this(camisaBean.getTime(), camisaBean.getAno(), camisaBean.getTamanho(), camisaBean.getEstado(),
                camisaBean.getCurtidas());
    }
}
