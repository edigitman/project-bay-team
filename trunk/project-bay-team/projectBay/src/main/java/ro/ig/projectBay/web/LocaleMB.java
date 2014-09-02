package ro.ig.projectBay.web;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "localeMB")
@SessionScoped
public class LocaleMB implements Serializable {

	private static final long serialVersionUID = 905375762230221180L;

	private Locale locale;
	
	private static final Logger logger = LoggerFactory.getLogger(LocaleMB.class);

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		logger.debug("Locale init with [{}]", locale.getLanguage());
	}

	// ======================================
	// = Business methods =
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
