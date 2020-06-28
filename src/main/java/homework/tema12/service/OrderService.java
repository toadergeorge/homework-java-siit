package homework.tema12.service;

import homework.tema12.entity.Order;
import homework.tema12.entity.OrderStatus;
import homework.tema12.entity.Product;
import homework.tema12.repository.OrderDAOImpl;
import homework.tema12.repository.OrderRepository;
import homework.tema12.repository.ProductDAOImpl;
import homework.tema12.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public void create(Product product) {
        productRepository.save(product);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Product> findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    public List<Order> findByOrderNumber(int orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void delete(String productCode) {
        productRepository.delete(productCode);
    }

    public static void main(String... args) {
//        OrderService orderService = new OrderService(new ProductDAOImpl());
//
//        Product productOne = Product.builder()
//                .productCode("S10_9992")
//                .productName("Lambo 22")
//                .productLine("Classic Cars")
//                .productScale("1:18")
//                .productVendor("Min Lin Diecast")
//                .productDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
//                .quantityInStock(6)
//                .buyPrice(20.66)
//                .MSRP(32.78)
//                .build();
//
//        //orderService.create(productOne);
//
//        orderService.findByProductCode("S10_9991")
//                .forEach(product -> System.out.println("product = " + product));
//
//
//        productOne.setProductName("AFTER UPDATE");
//        orderService.update(productOne);
//
//        orderService.findByProductCode("S10_9992")
//                .forEach(product -> System.out.println("product = " + product));
//
//        orderService.delete("S10_9991");


        OrderService orderService = new OrderService(new ProductDAOImpl(), new OrderDAOImpl());



//        Order orderOne = Order.builder()
//                .orderDate( LocalDate.of(2020, 6, 26))
//                .requireDate(LocalDate.of(2020, 6, 27))
//                .shippedDate(LocalDate.of(2020, 7, 21))
//                .status(OrderStatus.SHIPPED)
//                .comments("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy ")
//                .customerNumber(119)
//                .orderNumber(11111)
//                .build();
//
//        orderService.createOrder(orderOne);

        orderService.findByOrderNumber(11111)
                .forEach(order -> System.out.println("order = " + order));

//
//        productOne.setProductName("AFTER UPDATE");
//        orderService.update(productOne);
//
//        orderService.findByProductCode("S10_9992")
//                .forEach(product -> System.out.println("product = " + product));
//
//        orderService.delete("S10_9991");







    }
}
