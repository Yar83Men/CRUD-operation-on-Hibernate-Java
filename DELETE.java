package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DELETE {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);
            // DELETE employees WHERE name="Misha"
            session.createQuery("delete Employee where name='Misha'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done !");
        } finally {
            factory.close();
        }
    }
}
