package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SELECT {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            // SELECT * FROM employees WHERE id = 5
            Employee emp = session.get(Employee.class, 2);
            System.out.println(emp);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
