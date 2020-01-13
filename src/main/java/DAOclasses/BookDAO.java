package DAOclasses;

import DBTableObjects.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class BookDAO implements DAOInterface<Book,String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public BookDAO(){
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
        configuration.addAnnotatedClass(Book.class);
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
    public void persist(Book entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().save(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Book entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().update(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public Book findById(String id) {
        openCurrentSession();
        Book book = (Book) getCurrentSession().get(Book.class,id);
        closeCurrentSession();
        return book;
    }

    @Override
    public void delete(Book entity) {
        openCurrentSessionWithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionWithTransaction();
    }

    @Override
    public List findAll() {
        openCurrentSession();
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        closeCurrentSession();
        return books;
    }

    @Override
    public void deleteAll() {
        openCurrentSessionWithTransaction();
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
        closeCurrentSessionWithTransaction();
    }
}