package ovh.wzakrzewski.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.wzakrzewski.bookstore.dto.BookDTO;
import ovh.wzakrzewski.bookstore.entity.Kategoria;
import ovh.wzakrzewski.bookstore.entity.Ksiazka;
import ovh.wzakrzewski.bookstore.services.BookService;
import ovh.wzakrzewski.bookstore.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;
    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Ksiazka> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "bookslist";
    }

    @GetMapping("/bookformadd")
    public String addForm(Model model)
    {
        Ksiazka book = new Ksiazka();
        List<Kategoria> categories = categoryService.getCategories();

        model.addAttribute("book",book);
        model.addAttribute("categories",categories);
        return "addbookform";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Ksiazka ksiazka)
    {
        bookService.saveBook(ksiazka);
        return "redirect:/books/list";
    }

    @PostMapping("/saveBook2")
    public String saveBook2(@ModelAttribute("bookDTO") BookDTO bookDTO)
    {
        int id =bookDTO.getId();
        Ksiazka newks = bookService.getBook(id);
        if (newks==null){
            newks = new Ksiazka();
        }
        newks = new Ksiazka();
        Kategoria kat = categoryService.getCategory(bookDTO.getKategoriaid());
        newks.setKategoria(kat);
        newks.setNazwa(bookDTO.getNazwa());
        newks.setWydawnictwo(bookDTO.getWydawnictwo());
        newks.setCena(bookDTO.getCena());
        bookService.saveBook(newks);
        return "redirect:/books/list";
    }

    @GetMapping("/formadd2")
    public String addForm2(Model model) {
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categories", categoryService.getCategories());
        return "addbookform2";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam(name = "bookId") int id)
    {
        Ksiazka ksiazka = bookService.getBook(id);
        bookService.deleteBook(ksiazka);
        return "redirect:/books/list";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("bookDTO") BookDTO bookDTO)
    {
        Ksiazka book = new Ksiazka();
        Kategoria kat = categoryService.getCategory(bookDTO.getKategoriaid());

        book.setId(bookDTO.getId());
        book.setKategoria(kat);
        book.setNazwa(bookDTO.getNazwa());
        book.setWydawnictwo(bookDTO.getWydawnictwo());
        book.setCena(bookDTO.getCena());
        bookService.updateBook(book);
        return "redirect:/books/list";
    }

    @GetMapping("/updateBook/{id}")
    public String updateBookForm(@PathVariable int id, Model model){

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(id);
        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categories", categoryService.getCategories());
        return "updatebookform";
    }

}
