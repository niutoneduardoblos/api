package team.camisas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import team.camisas.api.camisa.CamisaRepository;
import team.camisas.api.camisa.DadosCadastroCamisaDTO;
import team.camisas.api.camisa.DadosListagemCamisaDTO;
import team.camisas.api.camisa.CamisaBean;

@RestController
@RequestMapping("/camisa")
public class CamisasController {

    @Autowired
    private CamisaRepository camisaRepository;

    @PostMapping
    @Transactional
    public void registrarCamisa(@RequestBody @Valid DadosCadastroCamisaDTO dados) {
        camisaRepository.save(new CamisaBean(dados));
    }

    @GetMapping
    public Page<DadosListagemCamisaDTO> listar(Pageable paginacao){
        return camisaRepository.findAll(paginacao).map(DadosListagemCamisaDTO::new);
    }
}
