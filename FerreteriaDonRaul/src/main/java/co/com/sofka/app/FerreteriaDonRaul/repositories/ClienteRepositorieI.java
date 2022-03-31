package co.com.sofka.app.FerreteriaDonRaul.repositories;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClienteRepositorieI extends ReactiveMongoRepository<Cliente, String> {
    public Flux<Cliente> findByCedulaCliente(String cedula);
}
