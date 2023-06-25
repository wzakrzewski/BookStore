package ovh.wzakrzewski.bookstore.services;

import ovh.wzakrzewski.bookstore.entity.Kategoria;

import java.util.List;

public interface CategoryService
{
    List<Kategoria> getCategories();

    Kategoria getCategory(int id);

    void saveCategory(Kategoria category);
    void updateCategory(Kategoria category);
    void deleteCategory(Kategoria category);
}
