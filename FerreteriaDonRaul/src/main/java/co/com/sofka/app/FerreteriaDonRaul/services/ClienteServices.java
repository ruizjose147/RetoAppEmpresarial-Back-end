package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ClienteDto;
import co.com.sofka.app.FerreteriaDonRaul.repositories.ClienteRepositorieI;
import org.modelmapper.ModelMapper;
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
}
