package repository.impl;

import model.Produto;
import repository.ProdutoRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository {

    private static final String QUERY = "SELECT produto " +
            "FROM Produto produto " +
            "INNER JOIN Categoria categoria ON produto.categoria = :categoria AND categoria.codigo = :categoria ";

    private EntityManager entityManager;

    public ProdutoRepositoryImpl setEntityManager(EntityManager em) {
        this.entityManager = em;
        return this;
    }

    public List<Produto> listByCategoria(Long categoria) {
        return entityManager.createQuery(QUERY, Produto.class)
                .setParameter("categoria", categoria)
                .getResultList();
    }

    public List<Produto> listByNomeAndCategoria(String nome, Long categoria) {
        return entityManager.createQuery(QUERY + "WHERE produto.nome LIKE :nome ", Produto.class)
                .setParameter("nome", nome.concat("%"))
                .setParameter("categoria", categoria)
                .getResultList();
    }

    @Override
    public List<Produto> listAll() {
        return entityManager.createQuery("SELECT produto FROM Produto produto", Produto.class).getResultList();
    }

    @Override
    public Produto findById(Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public void create(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    public void update(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public void delete(Long id) {
        var produto = entityManager.find(Produto.class, id);
        entityManager.remove(produto);
    }
}
