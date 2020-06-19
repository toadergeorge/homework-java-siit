package homework.tema12.service;

import homework.tema12.entity.Product;
import homework.tema12.repository.ProductDAOImpl;
import homework.tema12.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;

    //logica de milioane de $$
    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Product> findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void delete(String productCode) {
        productRepository.delete(productCode);
    }

    public static void main(String... args) {
        OrderService orderService = new OrderService(new ProductDAOImpl());

        Product productOne = Product.builder()
                .productCode("S10_9992")
                .productName("Lambo 22")
                .productLine("Classic Cars")
                .productScale("1:18")
                .productVendor("Min Lin Diecast")
                .productDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
                .quantityInStock(6)
                .buyPrice(20.66)
                .MSRP(32.78)
                .build();

        //orderService.create(productOne);

        orderService.findByProductCode("S10_9991")
                .forEach(product -> System.out.println("product = " + product));


        productOne.setProductName("AFTER UPDATE");
        orderService.update(productOne);

        orderService.findByProductCode("S10_9992")
                .forEach(product -> System.out.println("product = " + product));


        orderService.delete("S10_9991");

    }
}
