package org.IrvinCampos;

import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    private int lid;

    private String brand;
    private String model;
    private int ram;

    // Many laptops belong to one Alien
    @ManyToOne
//    @JoinColumn(name = "alien_id") // foreign key column
    private Alien alien;

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

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
        // Keep bidirectional relationship in sync
        if (alien != null && !alien.getLaptops().contains(this)) {
            alien.getLaptops().add(this);
        }
    }

    // --- toString for debugging ---
    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
