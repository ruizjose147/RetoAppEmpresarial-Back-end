package co.com.sofka.app.FerreteriaDonRaul.repositories;

import co.com.sofka.app.FerreteriaDonRaul.models.Inventario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepositorieI extends ReactiveMongoRepository<Inventario, String> {

}
