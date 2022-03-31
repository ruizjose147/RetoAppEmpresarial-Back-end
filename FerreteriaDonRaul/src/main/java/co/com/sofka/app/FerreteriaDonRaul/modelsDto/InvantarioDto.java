package co.com.sofka.app.FerreteriaDonRaul.modelsDto;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
@EqualsAndHashCode
@Data
public class InvantarioDto {

    String inventarioId;
    HashMap<Producto, Integer> producto;
}
