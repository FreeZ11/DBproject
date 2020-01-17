package DAOclasses;

import DBTableObjects.Czytelnik;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class CzytelnikDAO implements DAOInterface<Czytelnik,String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CzytelnikDAO(){
    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Czytelnik.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    @Override
    public void persist(Czytelnik entity){
        openCurrentSessionWithTransaction();
        getCurrentSession().save(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Czytelnik entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().update(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public Czytelnik findById(String id) {
        openCurrentSession();
        Czytelnik czytelnik = (Czytelnik) getCurrentSession().get(Czytelnik.class,id);
        closeCurrentSession();
        return czytelnik;
    }

    @Override
    public void delete(Czytelnik entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public List<Czytelnik> findAll() {
        openCurrentSession();
        List<Czytelnik> czytelnicy = (List<Czytelnik>) getCurrentSession().createQuery("from Czytelnik ").list();
        closeCurrentSession();
        return czytelnicy;
    }

    @Override
    public void deleteAll() {
        openCurrentSessionWithTransaction();
        List<Czytelnik> entityList = findAll();
        for (Czytelnik entity : entityList) {
            delete(entity);
        }
        closeCurrentSessionWithTransaction();
    }
}
