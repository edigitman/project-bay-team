package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.ResponseDAO;
import ro.ig.projectBay.model.Response;
import ro.ig.projectBay.service.ResponseService;

@Service(value = "responseService")
@Transactional(readOnly = true)
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	ResponseDAO responseDAO;

	@Override
	public List<Response> getResponseByProject(Integer id) {
		return responseDAO.getResponseByProject(id);
		// return null;
	}

}
