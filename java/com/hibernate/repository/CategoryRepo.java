package com.hibernate.repository;

import com.hibernate.model.Category;
import com.hibernate.model.Product;

import java.util.List;

public interface CategoryRepo<T> {
    List<T> findAll();

    T findById(T t);

    boolean inserIntoCategory(T t);

    boolean updateCategoryById(T t);

    boolean deleteCategoryById(T t);

}
