package homework.tema12.repository;

import homework.tema12.entity.Order;

import java.util.List;

public interface OrderRepository {

    void save(Order employee);

    List<Order> findByOrderNumber(String orderNumber);

    void update(Order order);

    void delete(int orderNumber);
}
