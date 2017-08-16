package io.egen.api.repository;

import java.util.List;
import io.egen.api.entity.Weather;

public interface WeatherRepository {
	
	public List<Weather> findAll();
	public Weather findOne(String id);
	//public Weather findByCity(String city);
	public Weather create(Weather weather);
	public Weather update(Weather weather);
	public void delete(Weather weather);

}
