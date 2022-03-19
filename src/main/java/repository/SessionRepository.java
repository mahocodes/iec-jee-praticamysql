package repository;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

public interface SessionRepository {

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public CategoriaRepository getCategoriaRepository();

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public ProdutoRepository getProdutoRepository();

}
