package ovh.wzakrzewski.bookstore.dao;

import ovh.wzakrzewski.bookstore.entity.Kategoria;

import java.util.List;

public interface CategoryDAO {
    List<Kategoria> getCategories();

    void saveCategory(Kategoria kategoria);

    Kategoria getCategory(int id);
    void deleteCategory(Kategoria category);
    void updateCategory(Kategoria category);
}
