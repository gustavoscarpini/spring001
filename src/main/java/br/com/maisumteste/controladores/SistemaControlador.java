package br.com.maisumteste.controladores;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Controller
@Scope(value = "session")
public class SistemaControlador implements Serializable {

    @SuppressWarnings("unchecked")
    public SistemaControlador() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletContext);

    }

    public String getUsuario() {
        return "José Afonso Libertino";
    }
}
