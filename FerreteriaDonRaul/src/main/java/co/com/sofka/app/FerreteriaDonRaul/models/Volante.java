package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Document(collection = "volantes")
public class Volante {

    @Id
    private String volanteId;
    @NonNull
    private String nombreProveedor;
    private LocalDate fechaVolante;
    @NonNull
    private String cedulaProveedor;
    @NonNull
    private HashMap<String, Integer> productosVolante;
}
