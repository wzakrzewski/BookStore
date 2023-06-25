package ovh.wzakrzewski.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.wzakrzewski.bookstore.entity.Autor;

import java.util.List;

@Repository
public class AuthorDAOimpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Autor> getAuthors() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Autor> query = currentSession.createQuery(" FROM Autor", Autor.class);
        List<Autor> authors = query.getResultList();

        return authors ;
    }

    @Override
    public Autor getAuthorById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Autor> query = currentSession.createQuery(" SELECT DISTINCT a FROM Autor a " +
                "WHERE a.id = :id", Autor.class).setParameter("id", id);


        return query.getSingleResult();
    }

    @Override
    public void saveAuthor(Autor author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }

    @Override
    public void deleteAuthor(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(autor);
    }

    @Override
    public void updateAuthor(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(autor);
    }

}
