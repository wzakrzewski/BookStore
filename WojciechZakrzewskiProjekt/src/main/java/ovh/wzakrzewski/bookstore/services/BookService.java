package ovh.wzakrzewski.bookstore.services;

import ovh.wzakrzewski.bookstore.entity.Ksiazka;

import java.util.List;
import java.util.Set;

public interface BookService {
    List<Ksiazka> getBooks(Set<Integer> booksIds);

    Ksiazka getBook(int id);
    List<Ksiazka> getAllBooks();
    void saveBook(Ksiazka ksiazka);
    void deleteBook(Ksiazka ksiazka);
    void updateBook(Ksiazka ksiazka);
}
