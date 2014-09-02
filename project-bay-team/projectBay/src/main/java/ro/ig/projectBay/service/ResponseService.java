package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Response;

public interface ResponseService {
	
	List<Response> getResponseByProject(Integer id);
	
}
