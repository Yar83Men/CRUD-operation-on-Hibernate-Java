package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class INSERT {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Employee emp = new Employee("Alice", "Ivanova", "HR", 900);


        try {
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Done !!!");
        } finally {
            factory.close();
        }
    }
}
