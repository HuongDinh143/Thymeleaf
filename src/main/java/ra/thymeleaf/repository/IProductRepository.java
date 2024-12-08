package ra.thymeleaf.repository;

import ra.thymeleaf.model.entity.Product;

import java.util.List;

public interface IProductRepository {
    //Các logic sử lý chức năng
    List<Product> findAll();
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Integer productId);
    Product findById(Integer productId);
    List<Product> findByName(String name);

}
