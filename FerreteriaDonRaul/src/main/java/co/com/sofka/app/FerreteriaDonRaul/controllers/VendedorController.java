package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Proveedor;
import co.com.sofka.app.FerreteriaDonRaul.models.Vendedor;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ProveedorDto;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.VendedorDto;
import co.com.sofka.app.FerreteriaDonRaul.services.ProveedorServices;
import co.com.sofka.app.FerreteriaDonRaul.services.VendedorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendedorController {

    @Autowired
    VendedorServices vendedorServices;
    ModelMapper modelMapper;

    public VendedorController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/vendedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Vendedor> save(@RequestBody VendedorDto vendedorDto){
        Vendedor vendedor = modelMapper.map(vendedorDto, Vendedor.class);
        return vendedorServices.save(vendedor);
    }

    @GetMapping("/vendedores")
    public Flux<VendedorDto> findAll() {
        return this.vendedorServices.findAll()
                .flatMap(v -> Mono.just(modelMapper.map(v, VendedorDto.class)));
    }

    @GetMapping("/vendedor/{id}")
    public Mono<VendedorDto> findById(@PathVariable("id") String id) {
        return this.vendedorServices.findById(id)
                .flatMap(v -> Mono.just(modelMapper.map(v, VendedorDto.class)));
    }

    @PutMapping("/vendedor/{id}")
    public Mono<Vendedor> updateVendedor(@PathVariable("id") String id, VendedorDto vendedorDto){
        Vendedor vendedor = modelMapper.map(vendedorDto, Vendedor.class);
        return this.vendedorServices.updateVendedor(id, vendedor);
    }

    @DeleteMapping("/vendedor/{id}")
    public Mono<ResponseEntity<Vendedor>> delete(@PathVariable("id") String id) {
        return this.vendedorServices.delete(id)
                .flatMap(p -> Mono.just(ResponseEntity.ok(p)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
