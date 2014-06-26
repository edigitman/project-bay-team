package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.ig.projectBay.dao.ResponseDAO;
import ro.ig.projectBay.model.Response;
import ro.ig.projectBay.service.ResponseService;

public class ResponseServiceImpl implements ResponseService {

	@Autowired
	ResponseDAO responseDAO;

	@Override
	public List<Response> getResponseByProject(Integer id) {
		return responseDAO.getResponseByProject(id);
	}

}
