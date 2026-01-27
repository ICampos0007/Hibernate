package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import java.util.Arrays;
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
        alien.setAname("Maelle");
        alien.setTech("Java");

        Alien alien2 = new Alien();
        alien2.setAid(4);
        alien2.setAname("Lune");
        alien2.setTech("Python");

        Alien alien3 = new Alien();
        alien3.setAid(5);
        alien3.setAname("Verso");
        alien3.setTech("C++");

        Laptop laptop = new Laptop();
        laptop.setLid(7);
        laptop.setBrand("ASUS");
        laptop.setModel("STRIX");
        laptop.setRam(32);

        Laptop laptop2 = new Laptop();
        laptop2.setLid(8);
        laptop2.setBrand("HP");
        laptop2.setModel("OMEN");
        laptop2.setRam(32);

        Laptop laptop3 = new Laptop();
        laptop3.setLid(9);
        laptop3.setBrand("Acer");
        laptop3.setModel("Swift");
        laptop3.setRam(32);

        alien.setLaptops(List.of(laptop,laptop2));
        alien2.setLaptops(List.of(laptop,laptop2,laptop3));
        alien3.setLaptops(List.of(laptop2,laptop3));

        laptop.setAliens(Arrays.asList(alien,alien2));
        laptop2.setAliens(Arrays.asList(alien,alien2,alien3));
        laptop3.setAliens(Arrays.asList(alien2,alien3));

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(laptop);
        session.persist(laptop2);
        session.persist(laptop3);

        session.persist(alien); // cascading saves laptops
        session.persist(alien2); // cascading saves laptops
        session.persist(alien3); // cascading saves laptops


        transaction.commit();
        session.close();
        sessionFactory.close();
    }


}
