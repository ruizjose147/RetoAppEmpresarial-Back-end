package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String idCliente;
    @NonNull
    private  String nombreCliente;
    @NonNull
    private String celularCliente;
    @NonNull
    private String cedulaCliente;
}
