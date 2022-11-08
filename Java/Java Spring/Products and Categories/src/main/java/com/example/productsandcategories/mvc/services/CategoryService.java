package com.example.productsandcategories.mvc.services;

import com.example.productsandcategories.mvc.models.Category;
import com.example.productsandcategories.mvc.models.Product;
import com.example.productsandcategories.mvc.repositories.CategoryRepository;
import com.example.productsandcategories.mvc.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;




    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Category> allCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category createCategory(Category d) {
        return categoryRepository.save(d);
    }

    public Category findCategory(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }
//    public Category addProductToCategory(Long categoryId, Long productId, Category category, Model model ){
//        Category thisCategory = findCategoryById(categoryId);
//        thisCategory.getProducts().add(thisProduct);
//        return categoryRepository.save(thisCategory);
//    }
    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId).get();
    }

    public Category update(Category thisCategory) {
        return categoryRepository.save(thisCategory);
    }
    public List<Category> proCat(Product product){
        return categoryRepository.findAllByProducts(product);

    }
    public List<Category> PrNotInca(Product product){
        return categoryRepository.findByProductsNotContains(product);
    }
}


