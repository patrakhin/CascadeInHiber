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

            /*Person_OtM personOtM = session.get(Person_OtM.class, 3);
            System.out.println(personOtM);

            List<Item> items = personOtM.getItems();
            System.out.println(items);*/

            /*Item item = session.get(Item.class, 5);
            System.out.println(item);

            Person_OtM personOtM = item.getOwner();
            System.out.println(personOtM);*/

            /*Person_OtM personOtM = session.get(Person_OtM.class, 2);

            Item newItem = new Item("Item for Hibernate", personOtM);

            personOtM.getItems().add(newItem);

            session.save(newItem);*/

            /*Person_OtM personOtM = new Person_OtM("Andrey", 47);
            Item newItem = new Item("automobile", personOtM);
            personOtM.setItems(new ArrayList<>(Collections.singletonList(newItem)));
            session.save(personOtM);
            session.save(newItem);*/

            /*Person_OtM personOtM = session.get(Person_OtM.class, 3);
            List<Item> items = personOtM.getItems();
            for (Item item:items) {
                session.remove(item);
            }

            personOtM.getItems().clear();*/

            /*Person_OtM personOtM = session.get(Person_OtM.class, 2);
            session.remove(personOtM);

            personOtM.getItems().forEach(i -> i.setOwner(null));*/

            Person_OtM personOtM = session.get(Person_OtM.class, 4);
            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);

            item.setOwner(personOtM);
            personOtM.getItems().add(item);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
