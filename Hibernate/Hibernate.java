package com.xec.Hibernate;

public class Hibernate {

/*    public Employee getEmployeeByEmail(String empEmail) {
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
