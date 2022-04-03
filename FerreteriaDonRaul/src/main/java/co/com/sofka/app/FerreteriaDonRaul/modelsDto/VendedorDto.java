package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Data
public class VendedorDto {

    private String vendedorId;
    private String vendedorNombre;
    private String vendedorCedula;
}
