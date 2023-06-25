package ovh.wzakrzewski.bookstore.dao;

import ovh.wzakrzewski.bookstore.entity.User;


public interface UserDAO {
    User getUser(String username);

    void saveUser(User user);
}
