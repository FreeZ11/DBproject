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
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Wypożyczone entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Wypożyczone findById(String id) {
        Wypożyczone wypożyczone = (Wypożyczone) getCurrentSession().get(Wypożyczone.class,id);
        return wypożyczone;
    }

    @Override
    public void delete(Wypożyczone entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Wypożyczone> findAll() {
        List<Wypożyczone> wypożyczone = (List<Wypożyczone>) getCurrentSession().createQuery("from Book").list();
        return wypożyczone;
    }

    @Override
    public void deleteAll() {
        List<Wypożyczone> entityList = findAll();
        for (Wypożyczone entity : entityList) {
            delete(entity);
        }
    }
}
