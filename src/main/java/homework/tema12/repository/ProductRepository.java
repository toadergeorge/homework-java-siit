package homework.tema12.repository;

import homework.tema12.entity.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product employee);

    List<Product> findByProductCode(String productCode);

    void update(Product product);

    void delete(String ProductCode);
}
