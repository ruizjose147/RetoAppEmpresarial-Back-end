package co.com.sofka.app.FerreteriaDonRaul.repositories;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductoRepositorieI extends ReactiveMongoRepository<Producto, String> {
    public Flux<Producto> findByNombreProducto(String nombre);
}
