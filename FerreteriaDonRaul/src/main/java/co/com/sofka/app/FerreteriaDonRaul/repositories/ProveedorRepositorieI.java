package co.com.sofka.app.FerreteriaDonRaul.repositories;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.models.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProveedorRepositorieI extends ReactiveMongoRepository<Proveedor, String> {
    public Flux<Proveedor> findByNombreProveedor(String nombre);
}
