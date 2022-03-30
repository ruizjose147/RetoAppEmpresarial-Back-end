package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Data
public class ProductoDto {

    String idProducto;
    String nombreProducto;
    String codigoProducto;
    Integer precioProducto;
    // TODO: 30/03/22 poner la conexion del idProveedor
}
