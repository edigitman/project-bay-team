package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ro.ig.projectBay.model.Response;
import ro.ig.projectBay.service.ProjectService;
import ro.ig.projectBay.service.ResponseService;

@ManagedBean(name = "responseOverviewBB")
@RequestScoped
public class ReponseOverviewBB {

	/*
	 * @ManagedProperty(value = "#{userService}") private UserService
	 * userService;
	 */

	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;

	@ManagedProperty(value = "#{responseService}")
	private ResponseService responseService;

	private List<Response> responsesList;

	@PostConstruct
	public void init() {
		responsesList = new ArrayList<Response>();
		responsesList = responseService.getResponseByProject(projectService
				.getCurrentProject().getId());
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public ResponseService getResponseService() {
		return responseService;
	}

	public void setResponseService(ResponseService responseService) {
		this.responseService = responseService;
	}

	public List<Response> getResponsesList() {
		return responsesList;
	}

	public void setResponsesList(List<Response> responsesList) {
		this.responsesList = responsesList;
	}

}
