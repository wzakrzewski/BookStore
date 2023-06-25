package ovh.wzakrzewski.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.wzakrzewski.bookstore.dao.AuthorDAO;
import ovh.wzakrzewski.bookstore.entity.Autor;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Autor> getAuthor() {
        List<Autor> authors = authorDAO.getAuthors();
        return authors;
    }

    @Override
    @Transactional
    public void saveAuthor(Autor autor) {
        authorDAO.saveAuthor(autor);

    }

    @Override
    @Transactional
    public void deleteAuthor(Autor autor) {
        authorDAO.deleteAuthor(autor);
    }

    @Override
    @Transactional
    public void updateAuthor(Autor autor) {
        authorDAO.updateAuthor(autor);
    }

    @Override
    @Transactional
    public Autor getAuthorById(int id) {
        return authorDAO.getAuthorById(id);
    }
}
