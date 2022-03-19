package repository.impl;

import model.Produto;
import repository.CrudRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoRepositoryImpl implements CrudRepository<Produto, Long> {

    private EntityManager entityManager;

    public ProdutoRepositoryImpl setEntityManager(EntityManager em) {
        this.entityManager = em;
        return this;
    }

    @Override
    public List<Produto> listAll() {
        return entityManager.createQuery("SELECT produto from Produto produto", Produto.class).getResultList();
    }

    @Override
    public Produto findById(Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public void update(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public void create(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    public void delete(Long id) {
        var produto = entityManager.find(Produto.class, id);
        entityManager.remove(produto);
    }
}
