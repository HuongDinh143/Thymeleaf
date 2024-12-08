package ra.thymeleaf.model.mapper;

import ra.thymeleaf.model.dto.ProductDto;
import ra.thymeleaf.model.entity.Product;

public class ProductMapper {
    public static Product mapDtoToEntity(ProductDto dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setProductPrice(dto.getProductPrice());
        product.setStock(dto.getStock());
        product.setUrl(dto.getUrl());
        return product;
    }
}
