package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SELECT_MANY {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employees = session.createQuery("from Employee")
//                    .getResultList();
            // SELECT * FROM employees WHERE name="Yaroslaw" AND salary > 2000
            List<Employee> employees = session
                    .createQuery("from Employee where name='Yaroslaw' and salary>2000")
                    .getResultList();

            for (Employee emp: employees) {
                System.out.println(emp);
            }

            session.getTransaction().commit();
            System.out.println("Done !");

        } finally {

        }

    }
}
