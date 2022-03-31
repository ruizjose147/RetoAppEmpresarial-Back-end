package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Data
public class FacturaDto {

    private String facturaId;
    private LocalDate fechaFactura;
    private String nombreVendedor;
    private String nombreCliente;
    private List<Producto> productosVendidos;
    private Integer totalFactura;
}
