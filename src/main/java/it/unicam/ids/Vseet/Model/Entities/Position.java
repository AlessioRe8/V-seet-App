package it.unicam.ids.Vseet.Model.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Position {

    private double latitude;

    private double longitude;
    private Comune comune;

    public Position() {}

    public Position(double latitude, double longitude, Comune comune) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.comune = comune;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
