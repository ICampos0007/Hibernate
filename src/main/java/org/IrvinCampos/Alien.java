package org.IrvinCampos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Alien {

    @Id
    private int aid;

    private String aname;

    private String tech;

    // One Alien can have many Laptops
    // 'mappedBy = "alien"' tells Hibernate that Laptop owns the foreign key
    //@OneToMany(mappedBy = "alien", cascade = CascadeType.ALL, orphanRemoval = true)
    @ManyToMany
    private List<Laptop> laptops;

    // --- Getters and Setters ---
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    // --- Optional: toString for debugging ---
    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
