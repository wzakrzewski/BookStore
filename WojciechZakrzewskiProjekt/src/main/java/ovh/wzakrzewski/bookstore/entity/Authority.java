package ovh.wzakrzewski.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@IdClass(AuthorityPK.class)
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    private String username;
    @Id
    private String authority;
    @ManyToOne
    @JoinColumn(name = "username", updatable = false, insertable = false)
    private User user;
    public Authority() {
    }
    public Authority(User user, String authority) {
        this.username = user.getUsername();
        this.authority = authority;
        this.user = user;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}