package ovh.wzakrzewski.bookstore.dao;

import ovh.wzakrzewski.bookstore.entity.Ksiazka;


import java.util.List;
import java.util.Set;

public interface BookDAO {
    List<Ksiazka> getBooks(Set<Integer> booksIds);
    List<Ksiazka> getAllBooks();
    void saveBook(Ksiazka ksiazka);
    Ksiazka getBook(int id);
    void deleteBook(Ksiazka ksiazka);
    void updateBook(Ksiazka ksiazka);

}
