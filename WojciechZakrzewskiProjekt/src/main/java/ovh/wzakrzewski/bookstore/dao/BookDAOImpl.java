package ovh.wzakrzewski.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.wzakrzewski.bookstore.entity.Ksiazka;


import java.util.List;
import java.util.Set;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Ksiazka> getAllBooks() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Ksiazka> query = currentSession.createQuery(" from Ksiazka", Ksiazka.class);
        List<Ksiazka> books = query.getResultList();

        return books ;
    }

    @Override
    public List<Ksiazka> getBooks(Set<Integer> booksIds) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = currentSession.createQuery("select distinct b from Ksiazka b " +
                        "left join fetch b.autorzy where b.id in (:ids)", Ksiazka.class)
                .setParameterList("ids", booksIds);

        return query.getResultList();
    }

    @Override
    public void saveBook(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ksiazka);
    }

    @Override
    public Ksiazka getBook(int bookid) {
        Session session = sessionFactory.getCurrentSession();
        Ksiazka ksiazka = session.get(Ksiazka.class,bookid);
        return ksiazka;
    }


    @Override
    public void deleteBook(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(ksiazka);
    }

    @Override
    public void updateBook(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.update(ksiazka);
    }
}
