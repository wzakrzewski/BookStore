package ovh.wzakrzewski.bookstore.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price")
    private float price;

    @Column(name="status")
    private String status;

    @Column(name = "date_time")
    private Timestamp date;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="username")
    private User user;

    @ManyToMany
    @JoinTable(
            name="zamowienia_to_ksiazki",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="ksiazka_id")

    )
    private Set<Ksiazka> ksiazki;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public Order(float price, String status, Timestamp date, User user) {
        this.price = price;
        this.status = status;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setBooks(HashSet<Ksiazka> books) {
        this.ksiazki = books;
    }

    public Set<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(Set<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;


    }

    public String getKsiazkiString() {
        String result = "";
        for (Ksiazka ksiazka:getKsiazki()) {
            result += ksiazka.getNazwa() + " " + ksiazka.getCena() + " ";
        }
        return result;
    }
}
