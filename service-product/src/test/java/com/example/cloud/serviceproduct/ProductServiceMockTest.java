package com.example.cloud.serviceproduct;

import com.example.cloud.serviceproduct.entity.Category;
import com.example.cloud.serviceproduct.entity.Product;
import com.example.cloud.serviceproduct.repository.ProductRepository;
import com.example.cloud.serviceproduct.service.ProductService;
import com.example.cloud.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);

        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("1240"))
                .status("Created")
                .createAt(new Date()).build();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product product = productService.getProduct(1L);

        Assertions.assertThat(product.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){

        Product productStock = productService.updateStock(1L, Double.parseDouble("8"));

        Assertions.assertThat(productStock.getStock()).isEqualTo(13);

    }
}
