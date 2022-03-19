package repository;

import model.Produto;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    public List<Produto> listByCategoria(Long categoria);

    public List<Produto> listByNomeAndCategoria(String nome, Long categoria);

}
