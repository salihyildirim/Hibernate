package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(City.class)
                .buildSessionFactory();


        // session Unit Of Work tasarım desenidir.
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            // HQL --> Hibernate Query Language // DİKKAT SELECT YOK. ÇÜNKÜ TÜM City dönüyor. Foreach ile istediğin alanı select gibi seçersin sonra.
            //List<City> cities =  from City c where c.countryCode='TUR' OR countryCode='EN' OR c.name LIKE '%F%'
            //INSERT
//            City city = new City();
//            city.setDistrict("kenya");
//            city.setName("KENYA");
//            city.setCountryCode("KEN");
//            city.setId(10);
//            city.setPopulation(650);
//            session.save(city);

            //UPDATE
//            City city = session.get(City.class,0);
//            city.setPopulation(1511);
//            session.save(city);

            //DELETE
//            City city = session.get(City.class,0);
//            session.delete(city);

            // Session, Unit Of Work olduğu için bir save'de hata varsa hepsini iptal eder.

            //List<Integer> populations = session.createQuery("select c.population from City c group by c.population ").getResultList();

//            List<City> populations = session.createQuery(" from City c where c.countryCode='TUR' OR countryCode='EN' OR c.name LIKE '%F%'").getResultList(); // .executeUpdate(); bir update delete sorgusu yazarsan.

//            for (City population : populations) {
//                System.out.println(population.getName());
//            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }


}
