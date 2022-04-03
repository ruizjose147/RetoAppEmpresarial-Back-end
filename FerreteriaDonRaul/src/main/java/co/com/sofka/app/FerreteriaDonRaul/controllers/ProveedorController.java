package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Proveedor;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ProveedorDto;
import co.com.sofka.app.FerreteriaDonRaul.services.ProveedorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProveedorController {

    @Autowired
    ProveedorServices proveedorServices;
    ModelMapper modelMapper;

    public ProveedorController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Proveedor> save(@RequestBody ProveedorDto proveedorDto){
        Proveedor proveedor = modelMapper.map(proveedorDto, Proveedor.class);
        return proveedorServices.save(proveedor);
    }

    @GetMapping("/proveedores")
    public Flux<ProveedorDto> findAll() {
        return this.proveedorServices.findAll()
                .flatMap(p -> Mono.just(modelMapper.map(p, ProveedorDto.class)));
    }

    @GetMapping("/proveedor/{id}")
    public Mono<ProveedorDto> findById(@PathVariable("id") String id) {
        return this.proveedorServices.findById(id)
                .flatMap(p -> Mono.just(modelMapper.map(p, ProveedorDto.class)));
    }

    @GetMapping("/proveedor/nombre/{nombre}")
    public Flux<ProveedorDto> findByNombreProveedor(String nombre){
        return this.proveedorServices.findByNombreProveedor(nombre)
                .flatMap(p -> Mono.just(modelMapper.map(p, ProveedorDto.class)));
    }

    @PutMapping("/proveedor/{id}")
    public Mono<Proveedor> updateProveedor(@PathVariable("id") String id, ProveedorDto proveedorDto){
        Proveedor proveedor = modelMapper.map(proveedorDto, Proveedor.class);
        return this.proveedorServices.updateProveedor(id, proveedor);
    }

    @DeleteMapping("/proveedor/{id}")
    public Mono<ResponseEntity<Proveedor>> delete(@PathVariable("id") String id) {
        return this.proveedorServices.delete(id)
                .flatMap(p -> Mono.just(ResponseEntity.ok(p)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
