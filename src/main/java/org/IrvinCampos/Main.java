package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSname("Gwen");
        student.setMarks(100);
        student.setSid(15);

//        Configuration configuration = new Configuration();
//        configuration.configure(); // loads hibernate.cfg.xml
//        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory(); //configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println(student);
    }
}