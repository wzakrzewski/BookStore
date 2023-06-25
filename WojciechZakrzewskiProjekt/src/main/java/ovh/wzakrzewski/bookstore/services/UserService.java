package ovh.wzakrzewski.bookstore.services;

import ovh.wzakrzewski.bookstore.entity.User;

public interface UserService {

    User getUser(String username);
    public void saveUser(User user);
}