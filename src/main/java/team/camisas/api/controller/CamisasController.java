package team.camisas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import team.camisas.api.camisa.CamisaRepository;
import team.camisas.api.camisa.DadosCadastroCamisaDTO;
import team.camisas.api.camisa.DadosListagemCamisaDTO;
import team.camisas.api.camisa.CurtirCamisaDTO;
import team.camisas.api.camisa.CamisaBean;

@RestController
@RequestMapping("/camisa")
public class CamisasController {

    @Autowired
    private CamisaRepository camisaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCamisaDTO dados, UriComponentsBuilder uriBuilder) {
        var camisabean = new CamisaBean(dados);
        camisaRepository.save(camisabean);
        
        var uri = uriBuilder.path("/camisa/{id}").buildAndExpand(camisabean.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemCamisaDTO(camisabean));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCamisaDTO>> listar(Pageable paginacao) {
        // size, page(Starts in zero) and sort(Use field name plus , asc or desc) are url parametres
        var page = camisaRepository.findAllByDeletadaFalse(paginacao).map(DadosListagemCamisaDTO::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping("/curtir/{id}")
    public ResponseEntity curtir(@PathVariable Long id) {
        var camisaBean = camisaRepository.getReferenceById(id);
        camisaBean.setCurtidas(camisaBean.getCurtidas()+1l);
        return ResponseEntity.ok(new DadosListagemCamisaDTO(camisaBean));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var camisaBean = camisaRepository.getReferenceById(id);
        camisaBean.setDeletada(true);
        camisaRepository.save(camisaBean);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var camisaBean = camisaRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemCamisaDTO(camisaBean));
    }
}
