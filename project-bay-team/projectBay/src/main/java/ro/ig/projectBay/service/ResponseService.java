package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Response;

public interface ResponseService {
	public List<Response> getResponseByProject(Integer id);
}
