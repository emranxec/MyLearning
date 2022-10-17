import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {


    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from Employee where email = :email");
        query.setParameter("email","imran@gmail.com");
        query.setCacheable(true);
        session.getTransaction();
        session.close();
    }
/*  public Employee getEmployeeByEmail(String empEmail) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where email = :email");
        query.setParameter("email", empEmail);
        return (Employee) query.list().get(0);
    }

    public EMployee getEMployeeByEmail(String[] filter){
        Query query =sessionFactory.getCurrentSession().createQuery("from Employee where name =: name");
        query.setParameter("name",filter[0]);
        return (Employee) query.list().get(0);
    }

    public Employee getEmployeeByEmail(String empEmail) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        crit.add(Restrictions.eq("email", empEmail)); //assuming Employee entity has "email" field
        return (Employee) crit.list().get(0);
    }


    public EMployee getEMployeeByEmail1(String[] filter) {
        Criteria crit = sessionFactory.getCurrentSesssion().createCriteria(Employee.class);
        String s=filter[0]+"%"+filter[1];
        crit.add(Restrictions.like("email",s));
        return (Employee) crit.list().get(0);
    }*/
    }
