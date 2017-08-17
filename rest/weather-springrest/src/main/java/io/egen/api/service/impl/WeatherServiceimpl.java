package io.egen.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Weather;
import io.egen.api.exception.BadRequestException;
//import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.NotFoundException;
import io.egen.api.repository.WeatherRepository;
//import io.egen.api.repository.WindRepository;
//import io.egen.api.repository.WindRepository;
import io.egen.api.service.WeatherService;

@Service
public class WeatherServiceimpl implements WeatherService{

	//@Autowired
	private WeatherRepository repository;
	//@Autowired
    //private WindRepository windRepo;
	
	public WeatherServiceimpl(WeatherRepository repository){
		this.repository = repository;
	}
	@Override
	@Transactional
	public Weather create(Weather weather) {
	
			return repository.create(weather);
		}
	
	@Override
	@Transactional(readOnly=true)
	public List<Weather> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Weather latestWeather(String city) {

		Weather existing= repository.latestWeather(city);
		if (existing == null)
		{
			throw new NotFoundException("Latest Weather for City = " + city + " does not exist" );
		}
		return existing;
	}

	@Override
	public String latestWeatherProperty(String city, String property) {
		
		String existing = repository.latestWeatherProperty(city, property);
		
		if (existing.isEmpty())
		{
			throw new NotFoundException("Latest Weather property = " + property+ " for city " + city + " does not exist");
		}
		return existing;
	}
//	@Override
//	public List<Weather> hourlyAvgWeather(String city) {
//		
//		 List<Weather> existing = repository.hourlyAvgWeather(city);
//		if (existing == null)
//		{
//			throw new NotFoundException("Hourly Average Weather for city = " + city + " does not exists");
//		}
//		return existing;
//		
//	}
//	@Override
//	public Weather dailyAvgWeather(String city, String date) {
//		
//		Weather existing = repository.dailyAvgWeather(city, date);
//		if (existing==null)
//		{
//			throw new NotFoundException("Daily Average Weather for city = " + city + " does not exists");
//		}
//		return existing;
//	}
	@Override
	@Transactional
	public Weather update(String id, Weather weather) {
		Weather existing = repository.latestWeather(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("Weather Reading with id " + id+ "does not exist");
		}
		return repository.update(weather);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		Weather existing = repository.latestWeather(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("Weather Reading with id " + id+ "does not exist");
		}
		repository.delete(existing);
	}
}
