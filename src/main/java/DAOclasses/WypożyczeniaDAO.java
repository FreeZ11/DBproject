package DAOclasses;

import DBTableObjects.Czytelnik;
import DBTableObjects.Wypożyczone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class WypożyczeniaDAO implements DAOInterface<Wypożyczone,String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public WypożyczeniaDAO(){

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
        configuration.addAnnotatedClass(Wypożyczone.class);
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
    public void persist(Wypożyczone entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().save(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Wypożyczone entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().update(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public Wypożyczone findById(String id) {
        openCurrentSession();
        Wypożyczone wypożyczone = (Wypożyczone) getCurrentSession().get(Wypożyczone.class,id);
        closeCurrentSession();
        return wypożyczone;
    }

    @Override
    public void delete(Wypożyczone entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public List<Wypożyczone> findAll() {
        openCurrentSession();
        List<Wypożyczone> wypożyczone = (List<Wypożyczone>) getCurrentSession().createQuery("from Book").list();
        closeCurrentSession();
        return wypożyczone;
    }

    @Override
    public void deleteAll() {
        openCurrentSessionWithTransaction();
        List<Wypożyczone> entityList = findAll();
        for (Wypożyczone entity : entityList) {
            delete(entity);
        }
        closeCurrentSessionWithTransaction();
    }
}
