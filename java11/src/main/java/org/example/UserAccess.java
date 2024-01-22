package org.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserAccess {

    private final SessionFactory sessionFactory;

    public UserAccess(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
        }
    }

    public void addProduct(Product product, Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            product.setCustomer(customer);

            session.persist(product);
            session.update(customer);

            session.getTransaction().commit();
        }
    }

    public List<Customer> getAllCustomers() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Customer.class);
            return criteria.list();
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Product.class);
            return criteria.list();
        }
    }

    public List<Product> getProductsByCustomer(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("customer", customer));
            return criteria.list();
        }
    }


    public Product getProductByName(Session session, String productName) {
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.eq("productName", productName));
        return (Product) criteria.uniqueResult();
    }


}