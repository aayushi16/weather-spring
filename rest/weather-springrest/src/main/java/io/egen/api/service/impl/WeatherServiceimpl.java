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
	@Transactional(readOnly=true)
	public List<Weather> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Weather findOne(String id) {
		// TODO Auto-generated method stub
		Weather existing = repository.findOne(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("Weather Reading with id " + id+ "does not exist");
		}
		return existing;
	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		// TODO Auto-generated method stub
		//windRepo.createWind(weather.getWind());
		
		Weather existing = repository.findByCity(weather.getCity());
		if(existing != null){
			//throw an runtime exception here which should return 400 to client	Bad Request. Weather Reading already exists
			throw new BadRequestException("Weather Reading for this City " +weather.getCity()+ "already exist");
			}
			return repository.create(weather);
		}

	@Override
	@Transactional
	public Weather update(String id, Weather weather) {
		Weather existing = repository.findOne(id);
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
		
		Weather existing = repository.findOne(id);
		if(existing == null){
		//throw an runtime exception here which should return 404 to client	
			throw new NotFoundException("Weather Reading with id " + id+ "does not exist");
		}
		repository.delete(existing);
	}
}
