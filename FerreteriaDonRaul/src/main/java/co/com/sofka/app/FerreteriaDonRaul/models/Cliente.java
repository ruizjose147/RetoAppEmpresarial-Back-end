package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Document(collection = "clientes")
public class Cliente {

    @Id
    String idCliente;
    String nombreCliente;
    String celularCliente;
    String cedulaCliente;
}
