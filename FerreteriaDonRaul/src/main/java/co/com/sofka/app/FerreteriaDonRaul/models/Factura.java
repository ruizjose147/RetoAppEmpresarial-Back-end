package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Document(collection = "facturas")
public class Factura {

    Integer facturaId;
    LocalDate fechaFactura;
    String nombreVendedor;
    String nombreCliente;
    List<Producto> productosVendidos;
    Integer totalFactura;

}
