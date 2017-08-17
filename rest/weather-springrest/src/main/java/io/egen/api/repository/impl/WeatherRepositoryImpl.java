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
	@Override
	public Weather create(Weather weather) {
		// TODO Auto-generated method stub
		em.persist(weather);
		return weather;
		
	}
	@Override
	public Weather latestWeather(String city) {
		// TODO Auto-generated method stub
		TypedQuery<Weather> query = em.createNamedQuery("Weather.latestWeather",Weather.class);
		query.setParameter("pCity", city);
		
		List<Weather> cList = query.getResultList();
		
		if (!cList.isEmpty())
		{
			return  cList.get(0);
		}
		else
		{
			return null; 
		}

	}
	@Override
	public String latestWeatherProperty(String city, String property) {

		TypedQuery<Weather> query = em.createNamedQuery("Weather.latestWeatherProperty", Weather.class);
		query.setParameter("pCity", city);

		List<Weather> pList = query.getResultList();

		if(!pList.isEmpty())
		{
			if (property.equals("temperature"))
			{
				String temp = pList.get(0).getTemperature(); 
				return "Latest Temperature at " + city + " is " + temp;
			}
			else if (property.equals("humidity"))
			{
				String humid = pList.get(0).getHumidity(); 
				return "Latest Humidity at " + city + " is " + humid;
			}
			else if (property.equals("pressure"))
			{
				String pressure = pList.get(0).getPressure();
				return "Latest Pressure at " + city + " is " + pressure; 
			}
		}
		return " No Valid Data Found For City " + city; 

	}
//	@Override
//	public List<Weather> hourlyAvgWeather(String city) {		
//		return null; 
//	}
//
//
//	@Override
//	public Weather dailyAvgWeather(String city, String date) {
//
//		return null;
//			
//	}

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
