package ovh.wzakrzewski.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.wzakrzewski.bookstore.entity.Kategoria;
import ovh.wzakrzewski.bookstore.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String listCategories(Model model)
    {
        List<Kategoria> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addFormCategory(Model model)
    {
        Kategoria category = new Kategoria();
        model.addAttribute("category",category);
        return "addcategoryform";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("categories") Kategoria category)
    {
        categoryService.saveCategory(category);
        return "redirect:/categories/list";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(name = "categoryId") int id)
    {
        Kategoria category = categoryService.getCategory(id);
        categoryService.deleteCategory(category);
        return "redirect:/categories/list";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute("category") Kategoria category)
    {
        categoryService.updateCategory(category);
        return "redirect:/categories/list";
    }

    @GetMapping("/updateCategory/{id}")
    public String updateCategoryForm(@PathVariable int id, Model model){
        Kategoria category = categoryService.getCategory(id);
        model.addAttribute("category",category);
        return "updatecategoryform";
    }
}
