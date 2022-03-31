package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ClienteDto;
import co.com.sofka.app.FerreteriaDonRaul.services.ClienteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;
    private ModelMapper modelMapper;

    public ClienteController(ModelMapper modelMapper) {c
        this.modelMapper = modelMapper;
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cliente> save(@RequestBody ClienteDto clienteDto){
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        return clienteServices.save(cliente);
    }

    @GetMapping("/clientes")
    public Flux<ClienteDto> findAll() {
        return this.clienteServices.findAll()
                .flatMap(c -> Mono.just(modelMapper.map(c, ClienteDto.class)));
    }
}
