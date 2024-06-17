package team.camisas.api.camisa;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.camisas.api.usuario.Usuario;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Camisa {
    
    @Id
    private Long id;
    private String time;
    private Integer ano;
    private Tamanho tamanho;
    private Estado estado;
    private Integer curtidas;
    private Date dataVersao;
    private Usuario usuario;
}
