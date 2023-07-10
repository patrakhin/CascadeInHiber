package org.example;


import org.example.model.Item;
import org.example.model.Person_OtM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

            Person_OtM personOtM = session.get(Person_OtM.class, 3);
            System.out.println(personOtM);

            List<Item> items = personOtM.getItems();
            System.out.println(items);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
