package org.IrvinCampos;

import jakarta.persistence.*;

@Entity
//@Table(name = "alien_table") //changes table name
public class Alien {
    @Id
    private int aid;
    //@Column(name = "alien_name") //changes column name
    private String aname;
    //@Transient //deletes/ignores this
    private String tech;
    private Laptop laptop;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
