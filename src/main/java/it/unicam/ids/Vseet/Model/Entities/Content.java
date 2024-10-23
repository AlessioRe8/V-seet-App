package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    String name;
    String description;
    @ManyToOne
    User creator;
    LocalDateTime creationDate;
    boolean approved = false;
    ContentCategory contentCategory;

    public Content(String name, String description, User creator, ContentCategory category) {
        this.creationDate = LocalDateTime.now();
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.contentCategory = category;
    }

    protected Content(){
        this.creationDate = LocalDateTime.now();
    };

    public abstract void approve();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getID() {
        return ID;
    }
    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
    }
    public ContentCategory getContentCategory() {
        return contentCategory;
    }
    public void setContentCategory(ContentCategory contentCategory) {
        this.contentCategory = contentCategory;
    }

}
