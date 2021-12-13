package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UPDATE {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(5000);
//
//            Employee emp1 = session.get(Employee.class, 1);
//            System.out.println(emp1);
            // UPDATE employees SET salary = 12500 WHERE name="Yaroslaw
            session
                    .createQuery("update Employee set salary=12500 where name='Yaroslaw'")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done !");

        } finally {
            factory.close();
        }
    }
}
