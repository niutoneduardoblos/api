package team.camisas.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioBean, Long> {

    UserDetails findByEmail(String email);

}
