package co.com.sofka.app.FerreteriaDonRaul.controllers;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ProductoDto;
import co.com.sofka.app.FerreteriaDonRaul.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    ModelMapper modelMapper;

    public ProductoController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Producto> save(@RequestBody ProductoDto productoDto){
        Producto producto = modelMapper.map(productoDto, Producto.class);
        return productoService.save(producto);
    }

    @GetMapping("/productos")
    public Flux<ProductoDto> findAll() {
        return this.productoService.findAll()
                .flatMap(p -> Mono.just(modelMapper.map(p, ProductoDto.class)));
    }

    @GetMapping("/producto/{id}")
    public Mono<ProductoDto> findById(@PathVariable("id") String id) {
        return this.productoService.findById(id)
                .flatMap(p -> Mono.just(modelMapper.map(p, ProductoDto.class)));
    }

    @GetMapping("producto/nombre/{nombre}")
    public Flux<ProductoDto> findByNombreProducto(String nombre){
        return this.productoService.findByNombreProducto(nombre)
                .flatMap(p -> Mono.just(modelMapper.map(p, ProductoDto.class)));
    }

    @PutMapping("/producto/{id}")
    public Mono<Producto> updateProducto(@PathVariable("id") String id, ProductoDto productoDto){
        Producto producto = modelMapper.map(productoDto, Producto.class);
        return this.productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/producto/{id}")
    public Mono<ResponseEntity<Producto>> delete(@PathVariable("id") String id) {
        return this.productoService.delete(id)
                .flatMap(p -> Mono.just(ResponseEntity.ok(p)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
