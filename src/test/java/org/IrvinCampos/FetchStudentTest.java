package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public class FetchStudentTest {

    @Test(enabled = false)
    public void getStudentTest() {
        Student student = new Student();
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory(); //configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        student = session.find(Student.class,10);

        session.close();
        sessionFactory.close();

        System.out.println(student);
    }

    @Test(enabled = false)
    public void fetchRamTest() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory(); //configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Laptop where ram =32");
        List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);
        session.close();
        sessionFactory.close();
    }

    @Test(enabled = true)
    public void fetchBrandTest() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory(); //configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String brand = "ASUS";
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1,brand);
        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops) {
            System.out.println((String) data[0] + " " + (String) data[1]);
        }

        System.out.println(laptops);
        session.close();
        sessionFactory.close();
    }
}
