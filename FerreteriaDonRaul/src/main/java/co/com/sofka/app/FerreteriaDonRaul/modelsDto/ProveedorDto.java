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
public class ProveedorDto {

    private String proveedorId;
    private String nombreProveedor;
    private String celularProveedor;
}
