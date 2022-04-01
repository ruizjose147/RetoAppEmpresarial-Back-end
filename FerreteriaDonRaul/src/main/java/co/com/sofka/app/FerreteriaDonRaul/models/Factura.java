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
    private Long consecutivo;
    private LocalDate fechaFactura;
    @NonNull
    private  String nombreVendedor;
    @NonNull
    private String nombreCliente;
    @NonNull
    private List<Producto> productosVendidos;
    @NonNull
    private Integer totalFactura;

}
