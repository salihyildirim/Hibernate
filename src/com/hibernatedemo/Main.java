package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(City.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            // HQL --> Hibernate Query Language // DİKKAT SELECT YOK. ÇÜNKÜ TÜM City dönüyor. Foreach ile istediğin alanı select gibi seçersin sonra.
            // from City c where c.countryCode='TUR' OR countryCode='EN' OR c.name LIKE '%F%'
            List<City> cities = session.createQuery("select c.countryCode  from City c group by c.countryCode ").getResultList();

            for (City city : cities) {
                System.out.println(city.getName());
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    public <T> void denemee(T x) {

    }
}
