package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;

//TODO POTREBBE ESSERE LEVATA!!!
@Entity
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;
    private String description;
    @Embedded
    private Position position;
    @ManyToOne
    User creator;
    @ManyToOne
    Comune comune;

    public Content(String name, String description, User creator,Position position, Comune comune) {
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.position = position;
        this.comune = comune;
    }

    protected Content(){};

    public enum ContentState {
        PENDING,
        APPROVED,
        DENIED
    }


    public Long getID() {
        return ID;
    }

    public Position getPosition() {
        return position;
    }

    public Comune getComune() {
        return comune;
    }

    public User getCreator() {
        return creator;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setPosition(Position position) { this.position = position;
    }

}
