package team.camisas.api.usuario;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "UsuarioBean")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioBean {

    @Id
    private Long id;
    private String nome;
    @Email
    private String email;
    private String senha;
    private Boolean ativo;
    private Boolean administrador;
    private Date dataVersao;
    private Long idUsuario;
}
