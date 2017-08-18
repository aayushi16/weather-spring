package io.egen.api.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity

@NamedQueries({
	@NamedQuery(name="Weather.findAll", query="SELECT w FROM Weather w ORDER BY w.city"),
	@NamedQuery(name="Weather.latestWeather", query="SELECT w FROM Weather w where w.city=:pCity"),
	@NamedQuery(name="Weather.latestWeatherProperty", query="SELECT w FROM Weather w where w.city=:pCity")
})
public class Weather {
	
	@Id
	private String id;
	private String city;
	private String description;
	private String humidity;
	private String pressure;
	private String temperature;
	  @OneToOne(cascade = { CascadeType.ALL })
	private Wind wind;
	
	private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	//String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date );
	//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//    Instant instant = timestamp.toInstant();
//    System.out.println(instant);

	public Weather() {
		// TODO Auto-generated constructor stub
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
