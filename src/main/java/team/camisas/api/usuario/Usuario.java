package team.camisas.api.usuario;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    private Long id;
    private String nome;
    @Email
    private String email;
    private String senha;
    private Boolean ativo;
    private Boolean administrador;
    private Date dataVersao;
    private Usuario usuario;
}
