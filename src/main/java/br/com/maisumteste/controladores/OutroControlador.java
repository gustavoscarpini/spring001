package br.com.maisumteste.controladores;

import br.com.maisumteste.facades.EstadoFacade;
import br.com.maisumteste.facades.SuperFacade;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
@ViewScoped
public class OutroControlador extends SuperControlador implements Serializable {

    @Autowired
    private EstadoFacade estadoFacade;

    public OutroControlador() {
        super();
    }

    public String getUsuario() {
        return sistemaControlador.getUsuario();
    }

    public String getNomeAplicacao() {
        return estadoFacade.getNomeAplicacao();
    }
}
