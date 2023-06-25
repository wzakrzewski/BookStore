package ovh.wzakrzewski.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ovh.wzakrzewski.bookstore.entity.Cart;
import ovh.wzakrzewski.bookstore.entity.Order;
import ovh.wzakrzewski.bookstore.entity.User;
import ovh.wzakrzewski.bookstore.services.BookService;
import ovh.wzakrzewski.bookstore.services.OrderService;

import java.sql.Timestamp;
import java.util.HashSet;

@Controller
@RequestMapping("")
public class OrderController {

    @Autowired
    private CartController cartController;
    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @Autowired
    private Cart cart;

    @GetMapping("/orders")
    public String getOrders(Authentication authentication, Model model) {

        model.addAttribute("orders", orderService.getOrders(authentication.getName()));

        return "order";
    }

    @GetMapping("/allorders")
    public String getAllOrders(Model model) {

        model.addAttribute("orders", orderService.getOrders());

        return "allorders";
    }

    @PostMapping("/orders")
    public String saveOrder(Authentication authentication) {
        Order order = new Order();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        order.setDate(timestamp);
        order.setStatus("pending");
        order.setUser(new User(authentication.getName()));
        order.setBooks(new HashSet<>(bookService.getBooks(cart.getBookIds())));
        order.setPrice(cartController.getTotalPrice());
        orderService.saveOrder(order);
        cart.getBookIds().clear();
        return "redirect:/orders";
    }

    @PostMapping("/orders/complete")
    public String completeOrder(@RequestParam(name = "orderId") int id) {
        orderService.completeOrder(id);
        return "redirect:/allorders";
    }


}
