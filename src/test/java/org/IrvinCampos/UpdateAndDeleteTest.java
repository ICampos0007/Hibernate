package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

public class UpdateAndDeleteTest {
    @Test( enabled = false)
    public void updateStudentTest() {
        Student student = new Student();
        student.setSname("Gwen");
        student.setMarks(99);
        student.setSid(15);

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(student);

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println(student);
    }

    @Test(enabled = false)
    public void deleteStudentTest() {
        Student student = new Student();

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        student = session.find(Student.class, 8);

        Transaction transaction = session.beginTransaction();

        session.remove(student);

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println(student);

    }


    @Test
    public void deleteAlienTest(){
        Alien alien = new Alien();

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        alien = session.find(org.IrvinCampos.Alien.class,101);

        Transaction transaction = session.beginTransaction();

        session.remove(alien);

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println(alien);
    }
}
