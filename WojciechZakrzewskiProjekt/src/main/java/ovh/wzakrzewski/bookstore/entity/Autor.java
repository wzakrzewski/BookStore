package ovh.wzakrzewski.bookstore.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="autorzy")
public class Autor {
    public Autor() {
    }

    public Autor(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="imie")
    private String imie;

    @Column(name="nazwisko")
    private String nazwisko;



    @ManyToMany
    @JoinTable(
            name="autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name="autor_id"),
            inverseJoinColumns = @JoinColumn(name="ksiazka_id")

    )
    private Set<Ksiazka> ksiazki;
    public void addKsiazka(Ksiazka ksiazka) {

        if (ksiazki == null) {
            ksiazki = new HashSet<>();
        }

        //ksiazka.addAutor(this);
        ksiazki.add(ksiazka);
    }
    public void removeKsiazka(Ksiazka ksiazka){
        if (ksiazki == null)
            return;
        //autor.addKsiazka(this);
        ksiazki.remove(ksiazka);


    }


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(Set<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
