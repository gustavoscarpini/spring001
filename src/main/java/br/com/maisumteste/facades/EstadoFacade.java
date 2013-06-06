package br.com.maisumteste.facades;

import br.com.maisumteste.modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EstadoFacade extends SuperFacade<Estado> {

    @PersistenceContext(unitName = "maisumtestePU")
    private EntityManager em;

    public EstadoFacade() {
        super(Estado.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public List<Estado> listar() {
        String hql = "from Estado e order by e.nome asc";
        Query q = getEntityManager().createQuery(hql);

        return q.getResultList();
    }
}
