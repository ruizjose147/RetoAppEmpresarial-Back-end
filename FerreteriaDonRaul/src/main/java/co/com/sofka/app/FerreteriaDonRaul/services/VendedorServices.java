package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Vendedor;
import co.com.sofka.app.FerreteriaDonRaul.repositories.VendedorRepositorieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendedorServices {

    @Autowired
    VendedorRepositorieI vendedorRepositorieI;

    public Mono<Vendedor> save(Vendedor vendedor) {
        return this.vendedorRepositorieI.save(vendedor);
    }

    public Flux<Vendedor> findAll() {
        return this.vendedorRepositorieI.findAll();
    }

    public Mono<Vendedor> findById(String id){
        return this.vendedorRepositorieI.findById(id);
    }

    public Flux<Vendedor> findByNombreVendedor(String nombre){
        return this.vendedorRepositorieI.findByVendedorNombre(nombre);
    }

    public Mono<Vendedor> findByCorreoVendedor(String correo){
        return this.vendedorRepositorieI.findByVendedorCorreo(correo);
    }

    public Mono<Vendedor> updateVendedor(String id, Vendedor vendedor){
        return this.vendedorRepositorieI.findById(id)
                .flatMap(v -> {
                    v.setVendedorId(vendedor.getVendedorId());
                    v.setVendedorNombre(vendedor.getVendedorNombre());
                    v.setVendedorCorreo(vendedor.getVendedorCorreo());
                    v.setVendedorCedula(vendedor.getVendedorCedula());
                    v.setVendedorPassword(vendedor.getVendedorPassword());
                    return save(v);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Vendedor> delete(String id) {
        return this.vendedorRepositorieI
                .findById(id)
                .flatMap(p -> this.vendedorRepositorieI.deleteById(p.getVendedorId())
                        .thenReturn(p));
    }
}
