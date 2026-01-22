package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

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

        Laptop laptop = new Laptop();
        laptop.setBrand("ASUS");
        laptop.setModel("ROG");
        laptop.setRam(32);

        Alien alien = new Alien();
        alien.setAid(1);
        alien.setAname("Naburishidi");
        alien.setTech("Java");
        alien.setLaptop(laptop);

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(alien);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
