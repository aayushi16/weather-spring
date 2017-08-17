package io.egen.api.service;

import java.util.List;




import io.egen.api.entity.Weather;

public interface WeatherService {

	
	public List<Weather> findAll();
	public Weather create(Weather weather);
	public Weather latestWeather(String city);
	public String latestWeatherProperty(String city, String property);
//	public List<Weather> hourlyAvgWeather(String city);
//	public Weather dailyAvgWeather(String city, String date);
	public Weather update(String id, Weather weather);
	public void delete(String id);
}
