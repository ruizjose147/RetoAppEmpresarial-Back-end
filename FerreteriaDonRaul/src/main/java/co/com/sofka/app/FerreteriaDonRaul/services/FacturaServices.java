package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Factura;
import co.com.sofka.app.FerreteriaDonRaul.repositories.FacturaRepositorieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class FacturaServices {

    @Autowired
    FacturaRepositorieI facturaRepositorieI;

    public Mono<Factura> save(Factura factura) {
        return this.facturaRepositorieI.save(factura);
    }

    public Flux<Factura> findAll() {
        return this.facturaRepositorieI.findAll();
    }

    public Mono<Factura> findById(String id){
        return this.facturaRepositorieI.findById(id);
    }

    public Mono<Factura> delete(Integer id) {
        String idString = String.valueOf(id);
        return this.facturaRepositorieI
                .findById(idString)
                .flatMap(f -> this.facturaRepositorieI.deleteById(f.getFacturaId().toString())
                        .thenReturn(f));
    }
}
