package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Volante;
import co.com.sofka.app.FerreteriaDonRaul.repositories.VolanteRepositorieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteServices {

    @Autowired
    VolanteRepositorieI volanteRepositorieI;

    public Mono<Volante> save(Volante volante) {
        return this.volanteRepositorieI.save(volante);
    }

    public Flux<Volante> findAll() {
        return this.volanteRepositorieI.findAll();
    }

    public Mono<Volante> findById(String id){
        return this.volanteRepositorieI.findById(id);
    }

    public Mono<Volante> delete(String id) {
        return this.volanteRepositorieI
                .findById(id)
                .flatMap(v -> this.volanteRepositorieI.deleteById(v.getVolanteId())
                        .thenReturn(v));
    }
}
