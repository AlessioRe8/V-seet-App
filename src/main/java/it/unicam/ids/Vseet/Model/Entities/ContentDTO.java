package it.unicam.ids.Vseet.Model.Entities;


import java.time.LocalDateTime;

public class ContentDTO {
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private ContentCategory contentCategory;
    private String type;
    private Position position;
    public ContentDTO(String name, String description, LocalDateTime creationDate, ContentCategory contentCategory, String type, Position position) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.contentCategory = contentCategory;
        this.type = type;
        this.position = position;
    }

    public ContentDTO() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public ContentCategory getContentCategory() {
        return contentCategory;
    }

    public String getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }
}
