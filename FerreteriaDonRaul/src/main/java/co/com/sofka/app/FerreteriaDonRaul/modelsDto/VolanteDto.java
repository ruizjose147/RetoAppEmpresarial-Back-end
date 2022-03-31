package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Data
public class VolanteDto {

    String volanteId;
    String nombreProveedor;
    LocalDate fechaVolante;
    String cedulaProveedor;
    HashMap<Producto, Integer> productosVolante;
}
