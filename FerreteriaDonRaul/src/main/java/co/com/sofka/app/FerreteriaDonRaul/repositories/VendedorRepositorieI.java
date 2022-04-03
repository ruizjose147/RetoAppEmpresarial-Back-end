package co.com.sofka.app.FerreteriaDonRaul.repositories;

import co.com.sofka.app.FerreteriaDonRaul.models.Vendedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VendedorRepositorieI extends ReactiveMongoRepository<Vendedor, String> {
    public Flux<Vendedor> findByVendedorNombre(String nombre);
}
