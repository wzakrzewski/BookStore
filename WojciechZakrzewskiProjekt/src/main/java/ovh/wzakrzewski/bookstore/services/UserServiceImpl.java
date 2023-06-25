package ovh.wzakrzewski.bookstore.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ovh.wzakrzewski.bookstore.dao.UserDAO;
import ovh.wzakrzewski.bookstore.entity.User;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User getUser(String username) {
        User user = userDAO.getUser(username);
        return user;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);
    }
}
