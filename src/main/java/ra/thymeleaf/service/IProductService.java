package ra.thymeleaf.service;

import ra.thymeleaf.model.dto.ProductDto;
import ra.thymeleaf.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(ProductDto request);
    boolean update(Product product);
    boolean delete(Integer productId);
    Product findById(Integer productId);
    List<Product> findByName(String name);
}
