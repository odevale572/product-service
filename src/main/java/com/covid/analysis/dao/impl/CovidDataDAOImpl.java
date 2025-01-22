package com.covid.analysis.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.covid.analysis.dao.CovidDataDAO;

public class CovidDataDAOImpl implements CovidDataDAO {
	private EntityManagerFactory entityManagerFactory;

    // Constructor to initialize the EntityManagerFactory
    public CovidDataDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
    }

	@Override
	public List<String> getAllStates() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		TypedQuery<String> query = entityManager.createQuery("SELECT distinct cd.state FROM "
				+ "CovidData cd order by cd.state ASC", String.class);
	    return query.getResultList();
	}

}
