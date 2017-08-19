package io.egen.api.service;

import java.util.List;




import io.egen.api.entity.Weather;

public interface WeatherService {

	
	public List<Weather> findAll();
	public Weather findOne(String id);
	public Weather create(Weather weather);
	public Weather update(String id, Weather weather);
	public void delete(String id);
}
