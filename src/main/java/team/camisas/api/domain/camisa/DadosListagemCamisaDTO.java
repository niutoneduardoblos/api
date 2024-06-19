package team.camisas.api.domain.camisa;

public record DadosListagemCamisaDTO(Long id, String time, Long ano, Tamanho tamanho, Estado estado, Long curtidas) {

    public DadosListagemCamisaDTO(CamisaBean camisaBean) {
        this(camisaBean.getId(), camisaBean.getTime(), camisaBean.getAno(), camisaBean.getTamanho(),
                camisaBean.getEstado(),
                camisaBean.getCurtidas());
    }
}
