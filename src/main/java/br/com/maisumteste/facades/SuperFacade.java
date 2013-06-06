package br.com.maisumteste.facades;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

public abstract class SuperFacade<T> {

    protected static final Logger logger = Logger.getLogger("br.com.br.com.maisumteste.facades.SuperFacade");
    private Class<T> classe;

    public SuperFacade(Class<T> classe) {
        this.classe = classe;
    }

    public Class<T> getClasse() {
        return classe;
    }

    protected abstract EntityManager getEntityManager();

    @Transactional
    public void inserir(T entity) {
        try {
            getEntityManager().persist(entity);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problema ao inserir");
        }
    }

    @Transactional
    public void alterar(T entity) {
        try {
            getEntityManager().merge(entity);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problema ao inserir", ex);
        }
    }

    @Transactional
    public void excluir(T entity) {
        try {
            getEntityManager().remove(entity);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problema ao excluir", ex);
        }
    }
    
    public String getNomeAplicacao(){
        return "Mais um Teste";
    }
}
