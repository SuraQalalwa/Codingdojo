package com.example.productsandcategories.mvc.services;

import com.example.productsandcategories.mvc.models.Category;
import com.example.productsandcategories.mvc.models.Product;
import com.example.productsandcategories.mvc.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> allProduct() {
        return (List<Product>) productRepository.findAll();
    }
    public Product createProduct(Product b) {
        return productRepository.save(b);
    }
    public Product findProduct(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public Product findProductById(Long productId) {
        return productRepository.findProductById(productId).get();
    }
    public List<Product> catProduct(Category category){
        return productRepository.findAllByCategories(category);

    }

    public Product update(Product thisProduct) {
        return productRepository.save(thisProduct);
    }

    public List<Product> catNotInPr(Category category){
        return productRepository.findByCategoriesNotContains(category);
    }
}
