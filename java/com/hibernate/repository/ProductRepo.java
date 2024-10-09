package com.hibernate.repository;

import com.hibernate.model.Product;

import java.util.List;

public interface ProductRepo<T> {
    List<T> findAll();

    T findById(T t);

    boolean inserIntoProduct(T t);

    boolean updateProductById(T t);

    boolean deleteProductById(T t);

    List<T> findProductByCategory(String proName, String catName);
}
