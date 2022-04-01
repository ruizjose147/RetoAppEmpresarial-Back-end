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
public class ProductoDto {

    private String idProducto;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioProducto;
    private String proveedorId;
}
