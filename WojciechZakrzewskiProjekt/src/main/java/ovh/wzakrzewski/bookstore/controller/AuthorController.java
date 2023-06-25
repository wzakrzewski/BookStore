package ovh.wzakrzewski.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.wzakrzewski.bookstore.entity.Autor;
import ovh.wzakrzewski.bookstore.services.AuthorService;


import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Autor> autorzy = authorService.getAuthor();
        model.addAttribute("autorzy",autorzy);
        return "authorlist";
    }

    @GetMapping("/authorformadd")
    public String addForm(Model model)
    {
        Autor autor = new Autor();
        model.addAttribute("autor",autor);
        return "addauthorform";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("autorzy") Autor autor)
    {
        authorService.saveAuthor(autor);
        return "redirect:/authors/list";
    }

    @PostMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam(name = "authorId") int id)
    {
        Autor autor = authorService.getAuthorById(id);
        authorService.deleteAuthor(autor);
        return "redirect:/authors/list";
    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("autor") Autor autor)
    {
        authorService.updateAuthor(autor);
        return "redirect:/authors/list";
    }

    @GetMapping("/updateAuthor/{id}")
    public String updateAuthorForm(@PathVariable int id, Model model){
        Autor autor = authorService.getAuthorById(id);
        model.addAttribute("autor",autor);
        return "updateauthorform";
    }

}



