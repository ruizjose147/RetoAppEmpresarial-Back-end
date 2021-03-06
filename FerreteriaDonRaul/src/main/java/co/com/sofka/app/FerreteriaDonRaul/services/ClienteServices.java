package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.repositories.ClienteRepositorieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepositorieI clienteRepositorieI;

    public Mono<Cliente> save(Cliente cliente) {
        return this.clienteRepositorieI.save(cliente);
    }

    public Flux<Cliente> findAll() {
        return this.clienteRepositorieI.findAll();
    }

    public Mono<Cliente> findById(String id){
        return this.clienteRepositorieI.findById(id);
    }

    public Flux<Cliente> findByCedula(String cedula){
        return this.clienteRepositorieI.findByCedulaCliente(cedula);
    }

    public Mono<Cliente> updateCliente(String id, Cliente cliente){
        return this.clienteRepositorieI.findById(id)
                .flatMap(c -> {
                    c.setNombreCliente(cliente.getNombreCliente());
                    c.setCelularCliente(cliente.getCelularCliente());
                    c.setCedulaCliente(cliente.getCedulaCliente());
                    return save(c);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Cliente> delete(String id) {
        return this.clienteRepositorieI
                .findById(id)
                .flatMap(p -> this.clienteRepositorieI.deleteById(p.getIdCliente())
                .thenReturn(p));
    }
}
