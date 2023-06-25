package ovh.wzakrzewski.bookstore.dao;

import ovh.wzakrzewski.bookstore.entity.Autor;


import java.util.List;

public interface AuthorDAO
{
    List<Autor> getAuthors();

    void saveAuthor(Autor autor);
    void deleteAuthor(Autor autor);
    void updateAuthor(Autor autor);
    Autor getAuthorById(int id);
}
