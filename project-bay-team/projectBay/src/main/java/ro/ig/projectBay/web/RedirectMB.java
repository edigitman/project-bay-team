package ro.ig.projectBay.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ro.ig.projectBay.util.Transition;

@ManagedBean(name = "redirectMB")
@SessionScoped
public class RedirectMB {
	private String currentPage;

	public String getProjectDetailsPage() {
		return Transition.PROJECT_DETAILS;
	}

	public String getCurrentPage() {
		if (currentPage == null) {
			currentPage = Transition.MAIN_PAGE;
		}
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
