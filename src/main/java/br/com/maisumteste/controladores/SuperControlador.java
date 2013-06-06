package br.com.maisumteste.controladores;


import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public abstract class SuperControlador {

    @Autowired
    protected SistemaControlador sistemaControlador;
  

    public SuperControlador() {
        injetarDependenciasSpring();
    }

    public final void injetarDependenciasSpring() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletContext);
    }
   
}
