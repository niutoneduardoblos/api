package team.camisas.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.camisas.api.camisa.DataRegisterCamisa;

@RestController
@RequestMapping("/camisas")
public class CamisasController {

    @PostMapping
    public void registrarCamisa(@RequestBody DataRegisterCamisa dados){
        System.out.println(dados);
    }
}
