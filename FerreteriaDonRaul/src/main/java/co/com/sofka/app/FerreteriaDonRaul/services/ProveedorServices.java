package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Proveedor;
import co.com.sofka.app.FerreteriaDonRaul.repositories.ProveedorRepositorieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServices {

    @Autowired
    ProveedorRepositorieI proveedorRepositorieI;

    public Mono<Proveedor> save(Proveedor proveedor) {
        return this.proveedorRepositorieI.save(proveedor);
    }

    public Flux<Proveedor> findAll() {
        return this.proveedorRepositorieI.findAll();
    }

    public Mono<Proveedor> findById(String id){
        return this.proveedorRepositorieI.findById(id);
    }

    public Flux<Proveedor> findByNombreProveedor(String nombre){
        return this.proveedorRepositorieI.findByNombreProveedor(nombre);
    }

    public Mono<Proveedor> updateProveedor(String id, Proveedor proveedor){
        return this.proveedorRepositorieI.findById(id)
                .flatMap(p -> {
                    p.setProveedorId(proveedor.getProveedorId());
                    p.setNombreProveedor(proveedor.getNombreProveedor());
                    p.setCelularProveedor(proveedor.getCelularProveedor());
                    return save(p);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Proveedor> delete(String id) {
        return this.proveedorRepositorieI
                .findById(id)
                .flatMap(p -> this.proveedorRepositorieI.deleteById(p.getProveedorId())
                        .thenReturn(p));
    }
}
