package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.models.Factura;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ClienteDto;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.FacturaDto;
import co.com.sofka.app.FerreteriaDonRaul.services.ClienteServices;
import co.com.sofka.app.FerreteriaDonRaul.services.FacturaServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaController {

    @Autowired
    FacturaServices facturaServices;
    ModelMapper modelMapper;

    public FacturaController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Factura> save(@RequestBody FacturaDto facturaDto){
        Factura factura = modelMapper.map(facturaDto, Factura.class);
        return facturaServices.save(factura);
    }

    @GetMapping("/facturas")
    public Flux<FacturaDto> findAll() {
        return this.facturaServices.findAll()
                .flatMap(f -> Mono.just(modelMapper.map(f, FacturaDto.class)));
    }

    @GetMapping("/factura/{id}")
    public Mono<FacturaDto> findById(@PathVariable("id") String id) {
        return this.facturaServices.findById(id)
                .flatMap(c -> Mono.just(modelMapper.map(c, FacturaDto.class)));
    }

    @DeleteMapping("/factura/{id}")
    public Mono<ResponseEntity<Factura>> delete(@PathVariable("id") String id) {
        return this.facturaServices.delete(Integer.valueOf(id))
                .flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
