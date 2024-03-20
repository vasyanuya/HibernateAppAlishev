package org.example.springcourse;


import org.example.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sF = config.buildSessionFactory();
        Session session = sF.getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("DELETE from Person  WHERE age < 30").executeUpdate();

//            Person p1 = new Person("Tom", 20);
//            Person p2 = new Person("Test1", 30);
//            Person p3 = new Person("Mike", 35);
//            Person p4 = new Person("John", 50);
//            Person p5 = new Person("Katy", 18);
//            session.save(p1);
//            session.save(p2);
//            session.save(p3);
//            session.save(p4);
//            session.save(p5);

            session.getTransaction().commit();
        } finally {
            sF.close();
        }
    }
}
