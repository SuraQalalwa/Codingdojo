package com.example.productsandcategories.mvc.controllers;

import com.example.productsandcategories.mvc.models.Category;
import com.example.productsandcategories.mvc.models.Product;
import com.example.productsandcategories.mvc.services.CategoryService;
import com.example.productsandcategories.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {
    private final CategoryService categoryService;
    private  final ProductService productService;

    public AppController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }
    @GetMapping("/")
    public String home(Model model,@ModelAttribute("product") Product product, @ModelAttribute("category") Category category) {
        List<Product> Product = productService.allProduct();
        List<Category> Category = categoryService.allCategory();
        model.addAttribute("products", Product);
        model.addAttribute("categories", Category);
        return "homePage.jsp";
    }

/////////////// Product /////////////////
    @GetMapping("/product/new")
    public String product(@ModelAttribute("product") Product product) {
    return "product.jsp";
    }
    @PostMapping("/product/new")
    public String newproduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product.jsp";
        }
        else {
            productService.createProduct(product);
            return "redirect:/product/new";
        }

    }
    @RequestMapping ("product/{id}")
    public String showProduct(@PathVariable("id") Long id,Model model, Category category){
        Product thisProduct = productService.findProductById(id);
        model.addAttribute("products", productService.findProduct(id));
        List<Category> categories = categoryService.PrNotInca(thisProduct);
        model.addAttribute("categories", categories);

        model.addAttribute("catpro", categoryService.proCat(thisProduct));
        return "showProduct.jsp";
    }
    @PostMapping("product/{id}")
    public String addCaToProduct(@PathVariable("id") Long id,@RequestParam(value = "categoryId") Long categoryId,Category category, Model model){
        Category thisCategory = categoryService.findCategoryById(categoryId);
        Product thisProduct = productService.findProductById(id);
        thisProduct.getCategories().add(thisCategory);
        productService.update(thisProduct);
        return "redirect:/product/" + id;
    }
//////////////////////////////////////////
/////////////// Category /////////////////
    @GetMapping("/category/new")
    public String category(@ModelAttribute("category") Category category) {
    return "category.jsp";
    }
    @PostMapping("/category/new")
    public String newcategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category.jsp";
        }
        else {
            categoryService.createCategory(category);
            return "redirect:/category/new";
        }
    }
    @RequestMapping("category/{id}")
    public String showCatagory(@PathVariable("id") Long id,Model model){
        Category thisCategory = categoryService.findCategoryById(id);
        model.addAttribute("categories", categoryService.findCategory(id));
        List<Product> products = productService.catNotInPr(thisCategory);
        model.addAttribute("products", products);
        model.addAttribute("procat", productService.catProduct(thisCategory));

        return "showCatagory.jsp";
    }
    @PostMapping("category/{id}")
    public String addProductToCa(@PathVariable("id") Long id,@RequestParam(value = "productId") Long productid,Product product, Model model){
        Category thisCategory = categoryService.findCategoryById(id);
        Product thisProduct = productService.findProductById(productid);
        thisCategory.getProducts().add(thisProduct);
        categoryService.update(thisCategory);
        return "redirect:/category/" + id;
    }
    }





