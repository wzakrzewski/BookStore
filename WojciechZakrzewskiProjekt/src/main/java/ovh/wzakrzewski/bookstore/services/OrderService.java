package ovh.wzakrzewski.bookstore.services;

import ovh.wzakrzewski.bookstore.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    List<Order> getOrders(String username);
    void saveOrder(Order order);
    void completeOrder(int orderId);
}
