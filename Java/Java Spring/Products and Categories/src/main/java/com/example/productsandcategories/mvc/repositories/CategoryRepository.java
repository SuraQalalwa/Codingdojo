package com.example.productsandcategories.mvc.repositories;

import com.example.productsandcategories.mvc.models.Category;
import com.example.productsandcategories.mvc.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    Optional<Category> findCategoryById(Long id);
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);


}
