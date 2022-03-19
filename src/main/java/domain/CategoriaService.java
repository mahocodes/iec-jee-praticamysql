package domain;

import lombok.RequiredArgsConstructor;
import model.Categoria;
import repository.CategoriaRepository;
import repository.SessionRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@Stateless
@RequiredArgsConstructor
public class CategoriaService {

    @EJB
    private SessionRepository sessionRepository;

    private CategoriaRepository categoriaRepository;


    @PostConstruct
    public void initialize() {
        categoriaRepository = sessionRepository.getCategoriaRepository();
    }


    public List<Categoria> listAll() {
        return categoriaRepository.listAll();
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(Categoria categoria) {
        categoriaRepository.create(categoria);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(Categoria categoria) {
        categoriaRepository.update(categoria);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Long id) {
        categoriaRepository.delete(id);
    }

}
