package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Document(collection = "inventario")
public class Inventario {

    String inventarioId;
    HashMap<Producto, Integer> producto;

}
