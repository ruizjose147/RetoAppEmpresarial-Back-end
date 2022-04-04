package co.com.sofka.app.FerreteriaDonRaul.services;

import co.com.sofka.app.FerreteriaDonRaul.models.Producto;
import co.com.sofka.app.FerreteriaDonRaul.modelsDto.ProductoDto;
import co.com.sofka.app.FerreteriaDonRaul.repositories.ProductoRepositorieI;
import com.mongodb.client.model.geojson.LineString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProductoServiceTest {

   

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByNombreProducto() {
    }

    @Test
    void updateProducto() {
    }

    @Test
    void delete() {
    }
}