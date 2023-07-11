package org.example;


import org.example.model.Item;
import org.example.model.Person_OtM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person_OtM.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person_OtM personOtM = new Person_OtM("Test person", 30);
            personOtM.addItem(new Item("Item 1"));
            personOtM.addItem(new Item("Item 2"));
            personOtM.addItem(new Item("Item 3"));

            session.save(personOtM);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
