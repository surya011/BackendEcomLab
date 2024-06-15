package online.store.model.wrappers;

import online.store.model.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductWrapper {
    public List<Product> products = Collections.emptyList();

    public ProductWrapper(List<Product> products) {
        this.products = Collections.unmodifiableList(products);
    }

    public List<Product> getProducts() {
        return products;
    }
}
