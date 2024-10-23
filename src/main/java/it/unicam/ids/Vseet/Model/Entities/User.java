package it.unicam.ids.Vseet.Model.Entities;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String username;
    private String fullName;
    private String email;
    private String password;
    private UserRole role;


    public User(String username, String fullName, String email,String password, UserRole role) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(){}

    public Long getID() {
        return ID;
    }

    public void setID(long id) {
        this.ID = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
