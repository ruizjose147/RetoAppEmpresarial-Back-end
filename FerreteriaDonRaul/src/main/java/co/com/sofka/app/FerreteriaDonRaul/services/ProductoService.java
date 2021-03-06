package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import co.com.sofka.app.FerreteriaDonRaul.repositories.ProductoRepositorieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    @Autowired
    ProductoRepositorieI productoRepositorieI;

    public Mono<Producto> save(Producto producto) {
        return this.productoRepositorieI.save(producto);
    }

    public Flux<Producto> findAll() {
        return this.productoRepositorieI.findAll();
    }

    public Mono<Producto> findById(String id){
        return this.productoRepositorieI.findById(id);
    }

    public Flux<Producto> findByNombreProducto(String nombre){
        return this.productoRepositorieI.findByNombreProducto(nombre);
    }

    public Mono<Producto> updateProducto(String id, Producto producto){
        return this.productoRepositorieI.findById(id)
                .flatMap(p -> {
                    p.setNombreProducto(producto.getNombreProducto());
                    p.setPrecioProducto(producto.getPrecioProducto());
                    p.setProveedorId(producto.getProveedorId());
                    return save(p);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Producto> delete(String id) {
        return this.productoRepositorieI
                .findById(id)
                .flatMap(p -> this.productoRepositorieI.deleteById(p.getIdProducto())
                        .thenReturn(p));
    }
}
