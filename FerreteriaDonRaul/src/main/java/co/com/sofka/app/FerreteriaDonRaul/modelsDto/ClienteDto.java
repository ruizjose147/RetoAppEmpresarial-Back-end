package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Data
public class ClienteDto {

    private String idCliente;
    private String nombreCliente;
    private String celularCliente;
    private String cedulaCliente;
}
