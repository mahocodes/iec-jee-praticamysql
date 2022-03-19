package repository;

import model.Categoria;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
public interface CrudRepository<CLASS, ID> {

    List<CLASS> listAll();

    CLASS findById(ID id);

    void update(CLASS entity);

    void create(CLASS entity);

    void delete(ID id);
}
