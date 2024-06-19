package team.camisas.api.domain.camisa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamisaRepository extends JpaRepository<CamisaBean, Long> {

    Page<CamisaBean> findAllByDeletadaFalse(Pageable paginacao);

}
