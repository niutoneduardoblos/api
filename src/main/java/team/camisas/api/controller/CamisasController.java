package team.camisas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import team.camisas.api.camisa.DadosCadastroCamisa;
import team.camisas.api.usuario.Usuario;

@RestController
@RequestMapping("/camisa")
public class CamisasController {

    //@Autowired
    //private CamisaRepository camisaRepository;

    @PostMapping
    public void registrarCamisa(@RequestBody @Valid DadosCadastroCamisa dados) {
//        camisaRepository.save(new Camisa(null, dados.time(), dados.ano(), dados.tamanho(), dados.estado(),
//               dados.curtidas(), dados.dataVersao(), dados.usuario()));
        System.out.println(dados);
    }
}
