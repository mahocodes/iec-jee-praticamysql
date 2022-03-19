package repository.impl;

import repository.CategoriaRepository;
import repository.ProdutoRepository;
import repository.SessionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SessionRepositoryImpl implements SessionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public CategoriaRepository getCategoriaRepository() {
        return new CategoriaRepositoryImpl().setEntityManager(em);    }

    @Override
    public ProdutoRepository getProdutoRepository() {
        return new ProdutoRepositoryImpl().setEntityManager(em);
    }
}
