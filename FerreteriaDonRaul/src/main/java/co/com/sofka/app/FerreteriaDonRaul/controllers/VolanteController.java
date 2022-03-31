package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Volante;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.VolanteDto;
import co.com.sofka.app.FerreteriaDonRaul.services.VolanteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VolanteController {

    @Autowired
    VolanteServices volanteServices;
    ModelMapper modelMapper;

    public VolanteController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/volante")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Volante> save(@RequestBody VolanteDto volanteDto){
        Volante volante = modelMapper.map(volanteDto, Volante.class);
        return volanteServices.save(volante);
    }

    @GetMapping("/volantes")
    public Flux<VolanteDto> findAll() {
        return this.volanteServices.findAll()
                .flatMap(v -> Mono.just(modelMapper.map(v, VolanteDto.class)));
    }

    @GetMapping("/volante/{id}")
    public Mono<VolanteDto> findById(@PathVariable("id") String id) {
        return this.volanteServices.findById(id)
                .flatMap(v -> Mono.just(modelMapper.map(v, VolanteDto.class)));
    }

    @DeleteMapping("/volante/{id}")
    public Mono<ResponseEntity<Volante>> delete(@PathVariable("id") String id) {
        return this.volanteServices.delete(id)
                .flatMap(v -> Mono.just(ResponseEntity.ok(v)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
