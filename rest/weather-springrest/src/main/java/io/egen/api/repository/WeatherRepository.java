package io.egen.api.repository;

import java.util.List;
import io.egen.api.entity.Weather;

public interface WeatherRepository {
	
	public List<Weather> findAll();
	public Weather create(Weather weather);
	public Weather latestWeather(String city);
	public String latestWeatherProperty(String city, String property);
//	public List<Weather> hourlyAvgWeather(String city);
//	public Weather dailyAvgWeather(String city, String date);
	public Weather update(Weather weather);
	public void delete(Weather weather);

}
