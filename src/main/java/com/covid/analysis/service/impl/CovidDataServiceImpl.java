package com.covid.analysis.service.impl;

import java.util.List;

import com.covid.analysis.dao.CovidDataDAO;
import com.covid.analysis.dao.impl.CovidDataDAOImpl;
import com.covid.analysis.service.CovidDataService;

public class CovidDataServiceImpl implements CovidDataService{

	private CovidDataDAO covidDataDAO = new CovidDataDAOImpl();
	
	@Override
	public List<String> getAllStates() {
		return covidDataDAO.getAllStates();
	}

}
