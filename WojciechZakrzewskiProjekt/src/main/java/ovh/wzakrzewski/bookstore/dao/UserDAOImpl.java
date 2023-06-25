package ovh.wzakrzewski.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.wzakrzewski.bookstore.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> query = currentSession.createQuery(" from User WHERE username=:username", User.class)
                .setParameter("username", username);
        User user = query.uniqueResult();

        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
