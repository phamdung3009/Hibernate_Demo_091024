package com.hibernate;

import com.hibernate.model.Category;
import com.hibernate.repository.CategoryRepo;
import com.hibernate.service.CategoryService;

import java.util.List;

public class CategoryMain {
    private static CategoryRepo categoryRepo = new CategoryService();

    public Category inserObjCat() {
        Category cat = new Category("Dien Tu");
        return cat;
    }

    public Category findById() {
        Category cat = new Category(5);
        return cat;
    }

    public Category update() {
        Category cat = new Category(5, "Dien Tu - Update");
        return cat;
    }

    public static void main(String[] args) {
//        categoryRepo.findAll();
//        categoryRepo.findById(new CategoryMain().findById());
//        categoryRepo.inserIntoCategory(new CategoryMain().inserObjCat());
//        categoryRepo.updateCategoryById(new CategoryMain().update());
        categoryRepo.deleteCategoryById(new CategoryMain().findById());
    }
}