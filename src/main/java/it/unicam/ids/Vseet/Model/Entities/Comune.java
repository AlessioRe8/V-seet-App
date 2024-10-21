package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.*;

@Embeddable
public class Comune{
    private String name;
    private double area;

    public Comune(String name, double area) {
        this.name = name;
        this.area = area;
    }

    protected Comune(){}
}
