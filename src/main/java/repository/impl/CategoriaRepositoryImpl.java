package repository.impl;

import model.Categoria;
import repository.CategoriaRepository;
import repository.CrudRepository;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import java.util.List;

@Singleton
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private EntityManager entityManager;

    public CategoriaRepositoryImpl setEntityManager(EntityManager em) {
        this.entityManager = em;
        return this;
    }

    @Override
    public List<Categoria> listAll() {
        return entityManager.createQuery("SELECT categoria from Categoria categoria", Categoria.class).getResultList();
    }

    @Override
    public Categoria findById(Long id) {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void create(Categoria categoria) {
        entityManager.persist(categoria);
    }

    @Override
    public void update(Categoria categoria) {
        entityManager.merge(categoria);
    }

    @Override
    public void delete(Long id) {
        var categoria = entityManager.find(Categoria.class, id);
        entityManager.remove(categoria);
    }
}
