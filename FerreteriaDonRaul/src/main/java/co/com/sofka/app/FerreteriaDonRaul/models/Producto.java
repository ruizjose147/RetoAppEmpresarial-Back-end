package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Document(collection = "productos")
public class Producto {
    
    @Id
    String idProducto;
    String nombreProducto;
    String codigoProducto;
    Integer precioProducto;
    // TODO: 30/03/22 poner la conexion del idProveedor
}
