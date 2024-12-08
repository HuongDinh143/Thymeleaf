package ra.thymeleaf.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.thymeleaf.model.entity.Product;
import ra.thymeleaf.repository.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class ProductRepositoryImp implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public boolean save(Product product) {
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try {
            entityManager.merge(product);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer productId) {
        try {
            Product deletedProduct = findById(productId);
            entityManager.remove(deletedProduct);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(Integer productId) {
        List<Product> results = entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :productId", Product.class)
                .setParameter("productId", productId)
                .getResultList();
        if (results.isEmpty()) {
            throw new NoSuchElementException("No product found with ID: " + productId);
        }
        return results.get(0);
    }

    @Override
    public List<Product> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return Collections.emptyList(); // Trả về danh sách rỗng nếu không có tên tìm kiếm
        }
        return entityManager.createQuery("from Product where productName like :name", Product.class)
                .setParameter("name", "%" +  name.trim() + "%")
                .getResultList();
    }
}
