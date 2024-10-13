package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;

@Entity
public class Comune{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private double area;
    @Embedded
    private Position position;

    public Comune(String name, double area, Position position) {
        this.name = name;
        this.area = area;
        this.position = position;
    }

    protected Comune(){}
}
