package co.com.sofka.app.FerreteriaDonRaul.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Document(collection = "facturas")
public class Factura {

    @Id
    private String facturaId;
    private LocalDate fechaFactura;
    private  String nombreVendedor;
    private String nombreCliente;
    private List<Producto> productosVendidos;
    private Integer totalFactura;

}
