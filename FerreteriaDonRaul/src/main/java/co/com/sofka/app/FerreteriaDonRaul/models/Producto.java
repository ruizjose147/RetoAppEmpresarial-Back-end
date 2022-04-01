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
@Document(collection = "inventario")
public class Producto {
    
    @Id
    private String idProducto;
    @NonNull
    private String nombreProducto;
    @NonNull
    private Integer cantidad;
    @NonNull
    private Double precioProducto;
    @NonNull
    private String proveedorId;

}
