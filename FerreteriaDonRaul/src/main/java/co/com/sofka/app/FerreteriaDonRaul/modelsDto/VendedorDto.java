package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Data
public class VendedorDto {

    String vendedorId;
    String vendedorNombre;
    String vendedorCelular;
    String vendedorCedula;
}
