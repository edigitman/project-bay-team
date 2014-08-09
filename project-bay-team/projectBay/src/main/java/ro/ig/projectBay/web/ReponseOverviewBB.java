package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.Collections;
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

	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;

	@ManagedProperty(value = "#{responseService}")
	private ResponseService responseService;

	private List<Response> responsesList;

	private double firstPrice;
	private double secondPrice;
	private double thirdPrice;

	@PostConstruct
	public void init() {
		responsesList = new ArrayList<Response>();
		responsesList = responseService.getResponseByProject(projectService
				.getCurrentProject().getId());
		calculateBestPrice();
	}

	public void calculateBestPrice() {
		List<Double> prices = new ArrayList<Double>();
		for (Response response : responsesList) {
			prices.add(new Double(response.getPrice()));
		}
		Collections.sort(prices);
		firstPrice = prices.get(0).doubleValue();
		int pos2 = 1;
		for (int i = 1; i < prices.size(); i++) {
			if (firstPrice > prices.get(i).doubleValue()) {
				secondPrice = prices.get(i).doubleValue();
				pos2 = i;
				break;
			}
		}
		for (int i = pos2 + 1; i < prices.size(); i++) {
			if (secondPrice > prices.get(i).doubleValue()) {
				thirdPrice = prices.get(i).doubleValue();
				break;
			}
		}
	}

	public String getImageName(Response response) {
		String name = new String();
		if (response.getPrice() == firstPrice) {
			name = "green.png";
		} else {
			name = "yellow.png";
		}
		return name;
	}

	public boolean renderRecommendation(Response response) {
		return (response.getPrice() >= thirdPrice) ? true : false;
	}

	public boolean getValidation(Response response) {
		return (response.getValidated() == 1) ? true : false;
	}

	public boolean getRejection(Response response) {
		return (response.getDenied() == 1) ? true : false;
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

	public double getFirstPrice() {
		return firstPrice;
	}

	public void setFirstPrice(double firstPrice) {
		this.firstPrice = firstPrice;
	}

	public double getSecondPrice() {
		return secondPrice;
	}

	public void setSecondPrice(double secondPrice) {
		this.secondPrice = secondPrice;
	}

	public double getThirdPrice() {
		return thirdPrice;
	}

	public void setThirdPrice(double thirdPrice) {
		this.thirdPrice = thirdPrice;
	}

}
