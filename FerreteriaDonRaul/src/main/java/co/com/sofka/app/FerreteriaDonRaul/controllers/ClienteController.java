package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ClienteDto;
import co.com.sofka.app.FerreteriaDonRaul.services.ClienteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

    @Autowired
    ClienteServices clienteServices;
    ModelMapper modelMapper;

    public ClienteController(ModelMapper modelMapper) {
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

    @GetMapping("/cliente/{id}")
    public Mono<ClienteDto> findById(@PathVariable("id") String id) {
        return this.clienteServices.findById(id)
                .flatMap(c -> Mono.just(modelMapper.map(c, ClienteDto.class)));
    }

    @GetMapping("/cliente/cedula/{cedula}")
    public Flux<ClienteDto> findByCedula(@PathVariable("cedula") String cedula){
        return this.clienteServices.findByCedula(cedula)
                .flatMap(c -> Mono.just(modelMapper.map(c, ClienteDto.class)));
    }

    @PutMapping("/cleinte/{id}")
    public Mono<Cliente> updateCliente(@PathVariable("id") String id, ClienteDto clienteDto){
         Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
         return this.clienteServices.updateCliente(id, cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public Mono<ResponseEntity<Cliente>> delete(@PathVariable("id") String id) {
        return this.clienteServices.delete(id)
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
