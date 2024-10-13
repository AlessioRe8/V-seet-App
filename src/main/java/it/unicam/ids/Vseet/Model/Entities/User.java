package it.unicam.ids.Vseet.Model.Entities;


import jakarta.persistence.*;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    String username;
    String fullName;
    String email;

    public User(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }

    protected User(){}

    public Long getID() {
        return ID;
    }

    public void setID(long id) {
        this.ID = id;
    }
}
