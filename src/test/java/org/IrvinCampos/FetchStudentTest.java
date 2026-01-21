package org.IrvinCampos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

public class FetchStudentTest {

    @Test
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
}
