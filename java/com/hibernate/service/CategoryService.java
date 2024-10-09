package com.hibernate.service;

import com.hibernate.model.Category;
import com.hibernate.repository.CategoryRepo;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements CategoryRepo<Category> {
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();


    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Category";
            categoryList = session.createQuery(hql).list();
            for (Category cats : categoryList) {
                System.out.println(cats);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categoryList;
    }

    @Override
    public Category findById(Category category) {
        Category cat = new Category();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Category c where c.id = :catId";
            Query query = session.createQuery(hql);
            query.setParameter("catId", category.getId());
            cat = (Category) query.uniqueResult();
            System.out.println(cat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cat;
    }

    @Override
    public boolean inserIntoCategory(Category category) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateCategoryById(Category category) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteCategoryById(Category category) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
