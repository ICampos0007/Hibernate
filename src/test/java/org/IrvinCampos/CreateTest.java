package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import java.util.List;

public class CreateTest {
    @Test(enabled = false)
    public void createStudentTest() {
        Student student = new Student();
        student.setSname("Budede");
        student.setMarks(1);
        student.setSid(8);

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println(student);
    }

    @Test
    public void CreateAlienTest() {
        Alien alien = new Alien();
        alien.setAid(3);
        alien.setAname("Esquie");
        alien.setTech("Java");

        Laptop laptop = new Laptop();
        laptop.setLid(3);
        laptop.setBrand("ASUS");
        laptop.setModel("ROG");
        laptop.setRam(32);

        Laptop laptop2 = new Laptop();
        laptop2.setLid(4);
        laptop2.setBrand("DELL");
        laptop2.setModel("XPS");
        laptop2.setRam(32);

        alien.setLaptops(List.of(laptop,laptop2));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(alien); // cascading saves laptops

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


}
