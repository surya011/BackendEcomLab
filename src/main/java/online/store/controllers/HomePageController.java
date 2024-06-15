package online.store.controllers;

import online.store.model.Product;
import online.store.model.wrappers.ProductWrapper;
import online.store.services.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class HomePageController {
    private ProductsService productService;

    public HomePageController(ProductsService productService) {
        this.productService = productService;
    }

    @GetMapping("/categories")
    public String getAllCategories() {
        return productService.getAllCategories()
                .stream()
                .collect(Collectors.joining(", " ));
    }

    @GetMapping("/deals_of_the_day/{number_of_products}")
    public ProductWrapper getDealsOfTheDay(@PathVariable(name = "number_of_products") int number_of_products) {
        return new ProductWrapper(productService.getDealsOfTheDay(number_of_products));
    }

    @GetMapping("/products")
    public ProductWrapper getAllProductsByCategory(@RequestParam(name="category", required=false) String category) {
        return new ProductWrapper(productService.getAllProductsByCategory(category));
    }
}