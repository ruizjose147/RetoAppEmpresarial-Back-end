package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Document(collection = "volantes")
public class Volante {

    String volanteId;
    String nombreProveedor;
    LocalDate fechaVolante;
    String cedulaProveedor;
    HashMap<Producto, Integer> productosVolante;
}
