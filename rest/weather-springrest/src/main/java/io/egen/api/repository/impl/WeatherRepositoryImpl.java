package io.egen.api.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import io.egen.api.entity.Weather;
import io.egen.api.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository{

	
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Weather> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findAll", Weather.class);
		return query.getResultList();
	}
//	@Override
//	public Weather findByCity(String city) {
//		// TODO Auto-generated method stub
//		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByCity", Weather.class);
//		query.setParameter("pCity", city);
//		List<Weather> weather = query.getResultList();
//		if(!weather.isEmpty())
//		{
//			return weather.get(0);
//		}else{
//		return null;
//	}
//	}
	@Override
	public Weather findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(Weather.class, id);
	}

	@Override
	public Weather create(Weather weather) {
		// TODO Auto-generated method stub
		em.persist(weather);
		return weather;
		
	}

	@Override
	public Weather update(Weather weather) {
		// TODO Auto-generated method stub
		return em.merge(weather);
		
	}

	@Override
	public void delete(Weather weather) {
		// TODO Auto-generated method stub
		em.remove(weather);
	}

}
