package team.camisas.api.domain.camisa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "camisas")
@Entity(name = "CamisaBean")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CamisaBean {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    private Long ano;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private Long curtidas;
    private Date dataVersao;
    private Boolean deletada;
    private Long idUsuario;

    public CamisaBean(@Valid DadosCadastroCamisaDTO dados) {
        this.time = dados.time();
        this.ano = dados.ano();
        this.tamanho = dados.tamanho();
        this.estado = dados.estado();
        this.curtidas = dados.curtidas();
        this.dataVersao = dados.dataVersao() == null ? new Date() : dados.dataVersao();
        this.idUsuario = dados.idUsuario();
        this.deletada = false;
    }

}
