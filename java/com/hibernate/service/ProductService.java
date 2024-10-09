package com.hibernate.service;

import com.hibernate.model.Category;
import com.hibernate.model.Product;
import com.hibernate.repository.ProductRepo;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductRepo<Product> {
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();


    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Product";
            products = session.createQuery(hql).list();
            for (Product p : products) {
                System.out.println(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public Product findById(Product product) {
        Product pro = new Product();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Product p where p.id = :proId";
            Query query = session.createQuery(hql);
            query.setParameter("proId", product.getId());
            pro = (Product) query.uniqueResult();
            System.out.println(pro);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pro;
    }

    public boolean saveOrUpdate(Product product) {
        Product pro = new Product();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
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
    public boolean inserIntoProduct(Product t) {
        return saveOrUpdate(t);
    }

    @Override
    public boolean updateProductById(Product t) {
        return saveOrUpdate(t);
    }

    @Override
    public boolean deleteProductById(Product t) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(t);
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
    public List<Product> findProductByCategory(String proName, String catName) {
        List<Product> products = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Product p WHERE p.name like :productName AND p.category.name like :categoryName");
            query.setParameter("productName", "%" + proName + "%");
            query.setParameter("categoryName", "%" + catName + "%");
            products = query.list();
//            for (Product p : products){
//                System.out.println(p);
//            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }
}
