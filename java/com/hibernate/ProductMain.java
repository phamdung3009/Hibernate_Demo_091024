package com.hibernate;

import com.hibernate.model.Category;
import com.hibernate.model.Product;
import com.hibernate.repository.ProductRepo;
import com.hibernate.service.ProductService;

import java.util.List;

public class ProductMain {
    private static ProductRepo repo = new ProductService();

    public Product findById() {
        Product product = new Product(10);
        return product;
    }

    public Product inserProduct() {
        Product product = new Product();
        product.setName("test");
        Category category = new Category(4);
        product.setCategory(category);
        return product;
    }

    public Product updateProduct() {
        Product product = new Product();
        product.setId(10);
        product.setName("test-update");
        Category category = new Category(4);
        product.setCategory(category);
        return product;
    }

    public static void main(String[] args) {
//        repo.findAll();
//        repo.findById(new ProductMain().findById());
//        repo.inserIntoProduct(new ProductMain().inserProduct());
//        repo.updateProductById(new ProductMain().updateProduct());
//        repo.deleteProductById(new ProductMain().findById());

//        repo.findProductByCategory("S", "m");
        List<Product> p = repo.findProductByCategory("S", "m");
        for (Product l : p ){
            System.out.println(l);
        }
    }
}