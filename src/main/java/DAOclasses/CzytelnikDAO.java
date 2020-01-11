package DAOclasses;

import DBTableObjects.Book;
import DBTableObjects.Czytelnik;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
    public void persist(Czytelnik entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Czytelnik entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Czytelnik findById(String id) {
        Czytelnik czytelnik = (Czytelnik) getCurrentSession().get(Czytelnik.class,id);
        return czytelnik;
    }

    @Override
    public void delete(Czytelnik entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Czytelnik> findAll() {
        List<Czytelnik> czytelnicy = (List<Czytelnik>) getCurrentSession().createQuery("from Book").list();
        return czytelnicy;
    }

    @Override
    public void deleteAll() {
        List<Czytelnik> entityList = findAll();
        for (Czytelnik entity : entityList) {
            delete(entity);
        }
    }
}
