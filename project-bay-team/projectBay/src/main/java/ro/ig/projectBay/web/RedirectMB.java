package ro.ig.projectBay.web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ro.ig.projectBay.util.Transition;

@ManagedBean(name = "redirectMB")
@ApplicationScoped
public class RedirectMB {
	private String currentPage;
	private final FacesContext context = FacesContext.getCurrentInstance();
	private final ExternalContext externalContext = context
			.getExternalContext();

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

	private String getURL() {
		HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();
		return request.getServletPath(); 
	}

	public String gotoCurrentProjects() {
		String url = getURL();
		String page = "secure/" + Transition.CURRENT_PROJECTS;
		setCurrentPage(page);
		if (!url.startsWith("/secure/")) {
			return page;
		}
		return Transition.CURRENT_PROJECTS;
	}

	public String gotoProjectDetails() {
		String page = "secure/";
		page = page + Transition.PROJECT_DETAILS;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.PROJECT_DETAILS;
	}

	public String gotoNewProject() {
		String page = "secure/" + Transition.NEW_PROJECT;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.NEW_PROJECT;
	}

	public String gotoPastProjects() {
		String page = "secure/" + Transition.PAST_PROJECTS;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.PAST_PROJECTS;
	}

	public String gotoWonProjects() {
		String page = "secure/";
		page = page + Transition.WON_PROJECTS;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.WON_PROJECTS;
	}

	public String gotoCollaboratorsOverview() {
		String page = "secure/";
		page = page + Transition.COLLABORATORS_OVERVIEW;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.COLLABORATORS_OVERVIEW;
	}

	public String gotoMyCollaborators() {
		String page = "secure/" + Transition.MY_COLLABORATORS;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.MY_COLLABORATORS;
	}

	public String gotoNewCollaborator() {
		String page = "secure/" + Transition.NEW_COLLABORATOR;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.NEW_COLLABORATOR;
	}

	public String gotoPastCollaborations() {
		String page = "secure/" + Transition.PAST_COLLABORATIONS;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.PAST_COLLABORATIONS;
	}

	public String gotoClearedProjects() {
		String page = "secure/" + Transition.CLEARED_PROJECTS;
		setCurrentPage(page);
		if (currentPage == null || "".equals(currentPage)
				|| !currentPage.startsWith("secure/")) {
			return page;
		}
		return Transition.CLEARED_PROJECTS;
	}
}
