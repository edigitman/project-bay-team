package ro.ig.projectBay.web;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class LocaleMB implements Serializable{

	private static final long serialVersionUID = 905375762230221180L;
	

	private Locale locale;
	
	@PostConstruct
	public void init(){
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();	
	}

    // ======================================
    // =          Business methods          =
    // ======================================

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
	
}
