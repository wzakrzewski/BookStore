package ovh.wzakrzewski.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.wzakrzewski.bookstore.entity.Cart;
import ovh.wzakrzewski.bookstore.entity.Ksiazka;
import ovh.wzakrzewski.bookstore.services.BookService;
import ovh.wzakrzewski.bookstore.services.OrderService;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private Cart cart;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String cart(Model model) {

        model.addAttribute("books", bookService.getBooks(cart.getBookIds()));
        model.addAttribute("totalPrice", getTotalPrice()+"");
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam(name = "bookId") int id) {
        cart.addBookId(id);
        return "redirect:/cart";
    }

    @PostMapping("/delete")
    public String deleteFromCart(@RequestParam(name = "bookId") int id) {
        cart.deleteBookId(id);
        return "redirect:/cart";
    }

    public float getTotalPrice() {
        float totalPrice = 0;

        for (Ksiazka book : bookService.getBooks(cart.getBookIds())) {
            totalPrice += book.getCena();
        }

        return totalPrice;
    }


}