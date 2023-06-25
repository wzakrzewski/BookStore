package ovh.wzakrzewski.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.wzakrzewski.bookstore.dao.CategoryDAO;
import ovh.wzakrzewski.bookstore.entity.Kategoria;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{

    @Autowired
    CategoryDAO categoryDAO;


    @Override
    @Transactional
    public List<Kategoria> getCategories() {

        List<Kategoria> categories = categoryDAO.getCategories();
        return categories;
    }

    @Override
    @Transactional
    public Kategoria getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void saveCategory(Kategoria category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public void updateCategory(Kategoria category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Kategoria category) {
        categoryDAO.deleteCategory(category);
    }
}
