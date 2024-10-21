package it.unicam.ids.Vseet.Model.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    String username;
    String password;
    String fullName;
    String email;
    @Column(name = "role")
    UserRole userRole;

    public User(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }

    public User(){}

    public Long getID() {
        return ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(long id) {
        this.ID = id;
    }

    public UserRole getRole() {
        return userRole;
    }
    public void setRole(UserRole role) {
        this.userRole = role;
    }
}
