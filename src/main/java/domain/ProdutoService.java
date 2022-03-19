package domain;

import lombok.RequiredArgsConstructor;
import model.Categoria;
import model.Produto;
import repository.ProdutoRepository;
import repository.SessionRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@Stateless
public class ProdutoService {

    @EJB
    private SessionRepository sessionRepository;

    private ProdutoRepository produtoRepository;


    @PostConstruct
    public void initialize() {
        produtoRepository = sessionRepository.getProdutoRepository();
    }

    public List<Produto> listByCategoria(Long categoria) {
        return produtoRepository.listByCategoria(categoria);
    }

    public List<Produto> listByNomeAndCategoria(String nome, Long categoria) {
        return produtoRepository.listByNomeAndCategoria(nome, categoria);
    }

    public List<Produto> listAll() {
        return produtoRepository.listAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(Produto produto) {
        produtoRepository.create(produto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(Produto produto) {
        produtoRepository.update(produto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Long id) {
        produtoRepository.delete(id);
    }

}
