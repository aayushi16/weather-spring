package io.egen.api.service.impl;

import java.util.List;
import java.util.Optional;

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
		return repository.findOne(id)
				.orElseThrow(()->new NotFoundException("Weather with id " + id+ "does not exist"));

	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		// TODO Auto-generated method stub
//		
//		Optional<Weather> mayExists=repository.findByCity(weather.getCity());
//		if(mayExists.isPresent()){
//			//throw an runtime exception here which should return 400 to client	Bad Request. Email already exists
//			throw new BadRequestException("Weather with city " +weather.getCity()+ "already exist");
//			}
			return repository.save(weather);

		}

	@Override
	@Transactional
	public Weather update(String id, Weather weather) {
		repository.findOne(id)
		.orElseThrow(()->new NotFoundException("Weather with id " + id+ "does not exist"));	
		return repository.save(weather);

	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		Weather existing = repository.findOne(id)	
				.orElseThrow(()->new NotFoundException("Weather with id " + id+ "does not exist"));
		repository.delete(existing);
	}

}
