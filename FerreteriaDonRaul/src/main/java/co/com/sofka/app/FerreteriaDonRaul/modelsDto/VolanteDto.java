package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

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

    private String volanteId;
    private String nombreProveedor;
    private LocalDate fechaVolante;
    private String cedulaProveedor;
    private HashMap<String, Integer> productosVolante;
}
