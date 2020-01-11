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
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Book entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Book findById(String id) {
        Book book = (Book) getCurrentSession().get(Book.class,id);
        return book;
    }

    @Override
    public void delete(Book entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List findAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        return books;
    }

    @Override
    public void deleteAll() {
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }
}