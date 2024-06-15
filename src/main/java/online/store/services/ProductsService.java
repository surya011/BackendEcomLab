package online.store.services;

import online.store.model.Product;
import online.store.model.ProductCategory;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Michael Pogrebinsky - www.topdeveloperacademy.com
 * Integrates with the database API and handles products and categories business logic
 */
@Service
public class ProductsService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductsService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    /**
     * Returns all the available categories of products in our online store

    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }
     */

    public List<String> getAllCategories() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategory -> productCategory.getCategory())
                .collect(Collectors.toList());
    }
    
    public List<Product> getDealsOfTheDay(int atmostNumberOfProducts) {
        return productRepository.findAtMostNumberOfProducts(atmostNumberOfProducts);
    }

    public List<Product> getAllProductsByCategory(String category) {
        if (category == null) {
            return productRepository.findAll();
        } else {
            return productRepository.findByCategory(category);

        }

    }
}
