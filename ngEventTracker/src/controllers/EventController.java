package controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import entities.*;
import data.eventDAO;

@RestController
public class EventController {
	
	@Autowired
	eventDAO dao;
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "index",method = RequestMethod.GET)
	public Set<UserExperience> index(){
		
		return dao.index();
	}
	@RequestMapping(path = "create",method = RequestMethod.POST)
	public UserExperience create(@RequestBody String eventJson){
		return dao.create(eventJson);
	}
	@RequestMapping(path = "show/{id}",method = RequestMethod.GET)
	public UserExperience show(@PathVariable int id){
		return dao.show(id);
	}
	@RequestMapping(path = "DELETE/{id}",method = RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id){
		return dao.destroy(id);
	}
	@RequestMapping(path = "update/{id}",method = RequestMethod.PUT)
	public UserExperience update(@PathVariable int id, @RequestBody String eventJson){
		return dao.update(id, eventJson);
	}
	

}
