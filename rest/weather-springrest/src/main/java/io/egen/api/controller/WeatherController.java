package io.egen.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.constants.URI;
import io.egen.api.entity.Weather;
import io.egen.api.WebConfig;
import io.egen.api.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "http://mocker.egen.io", allowedHeaders="*",allowCredentials="true", maxAge=3600)

@RequestMapping(value=URI.WEATHER)
@Api(tags="weather")
public class WeatherController {

	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	//@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Find All Cities", notes = "Get the list of cities that have ever reported their weather in the past")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public List<Weather> findAll(){
		return service.findAll();
	}
	
	//@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value=URI.ID)
	@ApiOperation(value="Find Weather Readings by Id", notes = "Returns a weather reading by id if it exist in the app")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public Weather findOne(@PathVariable("id") String id){
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Create Weather Readings", notes = "App that accepts Weather Readings")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=400, message="Bad Request"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public Weather create(@RequestBody Weather weather){
		
		return service.create(weather);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value=URI.ID)
	@ApiOperation(value="Update Weather Readings", notes = "Update an existing Weather Reading")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public Weather update(@PathVariable("id") String id, @RequestBody Weather weather){
		return service.update(id, weather);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value=URI.ID)
	@ApiOperation(value="Delete Weather Readings", notes = "Delete an existing Reading")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Internal Server error")
	})
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
}
