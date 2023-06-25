package ovh.wzakrzewski.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.wzakrzewski.bookstore.entity.Order;
import ovh.wzakrzewski.bookstore.services.UserService;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private UserService userService;
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Order> getOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery(" from Order", Order.class);
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public List<Order> getOrders(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> query = currentSession.createQuery("select distinct b from Order b " +
                        "left join fetch b.user where b.user.username =:name", Order.class)
                .setParameter("name", username);

        return query.getResultList();
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public void completeOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        order.setStatus("completed");
        session.save(order);
    }
}
