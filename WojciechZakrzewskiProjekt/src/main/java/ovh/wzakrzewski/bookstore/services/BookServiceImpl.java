package ovh.wzakrzewski.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.wzakrzewski.bookstore.dao.BookDAO;
import ovh.wzakrzewski.bookstore.dao.CategoryDAO;
import ovh.wzakrzewski.bookstore.entity.Ksiazka;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Ksiazka> getAllBooks() {
        List<Ksiazka> books = bookDAO.getAllBooks();
        return books;
    }

    @Override
    @Transactional
    public List<Ksiazka> getBooks(Set<Integer> booksIds) {
        if(booksIds.isEmpty()) {
            return Collections.emptyList();
        } else {
            return bookDAO.getBooks(booksIds);
        }
    }

    @Override
    @Transactional
    public Ksiazka getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void saveBook(Ksiazka ksiazka) {
        //List<Kategoria> kategorie = categoryDAO.getCategories();
        //ksiazka.setKategoria(kategorie.get(0));
//        Kategoria kategoria = ksiazka.getKategoria();
//        kategoria.setId(Integer.parseInt(kategoria.getNazwa()));

        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public void deleteBook(Ksiazka ksiazka) {
        bookDAO.deleteBook(ksiazka);
    }

    @Override
    @Transactional
    public void updateBook(Ksiazka ksiazka) {
        bookDAO.updateBook(ksiazka);
    }
}
