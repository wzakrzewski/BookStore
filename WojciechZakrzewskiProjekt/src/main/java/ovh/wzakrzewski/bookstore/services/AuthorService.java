package ovh.wzakrzewski.bookstore.services;

import ovh.wzakrzewski.bookstore.entity.Autor;

import java.util.List;

public interface AuthorService {
    List<Autor> getAuthor();

    void saveAuthor(Autor autor);
    void deleteAuthor(Autor autor);
    void updateAuthor(Autor autor);
    Autor getAuthorById(int id);
}