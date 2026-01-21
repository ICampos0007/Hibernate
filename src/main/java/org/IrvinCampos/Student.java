package org.IrvinCampos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student") // maps to your PostgreSQL table
public class Student {

    @Id
    @Column(name = "sid") // primary key column in table
    private int sid;

    @Column(name = "sname") // name column in table
    private String sname;

    @Column(name = "marks") // marks column in table
    private int marks;

    // Default constructor
    public Student() {}

    // Getters and setters
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", marks=" + marks +
                '}';
    }
}
