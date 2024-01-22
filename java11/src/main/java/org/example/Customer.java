package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Customers")
public class Customer {

    public String getProducts;
    // Уникальный идентификатор клиента
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private int customerId;

    // Имя клиента
    @Column(name = "customer_name")
    private String customerName;

    // Список продуктов, принадлежащих клиенту (один клиент может иметь много продуктов)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Product> products;

    @Override
    public String toString() {

        if (products != null && !products.isEmpty()) {
            return  "Список "+products ;
        } else {
            return "Лист пуст";
        }
    }

    // Пустой конструктор (необходим для Hibernate)
    public Customer() {
    }

    // Конструктор с параметром для установки имени клиента
    public Customer(String customerName) {
        this.customerName = customerName;
    }

    // Методы доступа (геттеры и сеттеры)

    // Получение уникального идентификатора клиента
    public int getCustomerId() {
        return customerId;
    }

    // Установка уникального идентификатора клиента
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Получение имени клиента
    public String getCustomerName() {
        return customerName;
    }


    // Получение списка продуктов, принадлежащих клиенту
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    public List<Product> getProducts() {
        return products;
    }

    // Методы equals и hashCode (опциональные, генерируются на основе ваших потребностей)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Objects.equals(customerName, customer.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName);
    }
}