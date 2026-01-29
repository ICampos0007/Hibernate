package org.IrvinCampos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lid;

    private String brand;
    private String model;
    private int ram;

    // Many laptops belong to one Alien
    //@ManyToOne
//    @JoinColumn(name = "alien_id") // foreign key column
    @ManyToMany(mappedBy = "laptops")
    private List<Alien> aliens;

    // --- Getters and Setters ---
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    // --- toString for debugging ---


    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", ram=" + ram +
                '}';
    }
}
