package DAOclasses;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T, Id extends Serializable> {

    public void persist(T entity) throws SQLException;

    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();

}
