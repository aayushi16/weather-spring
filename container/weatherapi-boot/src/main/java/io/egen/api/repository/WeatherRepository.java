package io.egen.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import io.egen.api.entity.Weather;

public interface WeatherRepository extends Repository<Weather, String>{
	
	public List<Weather> findAll();
	//public Page<User> findAll(Pageable pageable);
	public Optional<Weather> findOne(String Id);
	//public Optional<Weather> findByCity(String email);
	public Weather save(Weather weather);  //update and insert
	public void delete(Weather weather);
}
