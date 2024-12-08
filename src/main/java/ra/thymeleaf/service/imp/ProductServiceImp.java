package ra.thymeleaf.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.thymeleaf.model.dto.ProductDto;
import ra.thymeleaf.model.entity.Product;
import ra.thymeleaf.model.mapper.ProductMapper;
import ra.thymeleaf.repository.IProductRepository;
import ra.thymeleaf.service.IProductService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(ProductDto request) {
        //Biến đổi từ dto==> entity
        Product productEntity = ProductMapper.mapDtoToEntity(request);
        productEntity.setCreateTime(LocalDate.now());
        productEntity.setStatus(true);
        return productRepository.save(productEntity);

    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(Integer productId) {
        return productRepository.delete(productId);
    }

    @Override
    public Product findById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}
