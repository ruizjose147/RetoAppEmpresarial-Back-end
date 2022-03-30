package co.com.sofka.app.FerreteriaDonRaul.mapper;

import co.com.sofka.app.FerreteriaDonRaul.models.Cliente;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ClienteDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperClienteI {


        ClienteDto toClienteDto(Cliente cliente);

        @InheritInverseConfiguration
        Cliente toCliente(ClienteDto clienteDto);
}
