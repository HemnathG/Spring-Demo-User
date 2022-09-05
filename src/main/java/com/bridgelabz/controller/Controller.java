package com.bridgelabz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.UserDto;
import com.bridgelabz.service.IUserService;
import com.bridgelabz.utility.Response;

@RestController //@Controller + @Response Body
@RequestMapping("/home")
public class Controller {

	@Autowired
	IUserService userService;

	@GetMapping("/get")
	public ResponseEntity<String> gethello() {
		return new ResponseEntity<String>("Hello World, Iam Hemanth G", HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<Response> addUser(@RequestBody UserDto userDto) {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.addUser(userDto), HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Integer id) {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.deleteUser(id), HttpStatus.OK);
		return response;
		
	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.updateUser(id, userDto), HttpStatus.OK);
		return response;
	}

	@GetMapping("/getdata")
	public ResponseEntity<List<UserDto>> getList() {
		List<UserDto> getdetails =userService.findAll();
		return new ResponseEntity<List<UserDto>>(getdetails, HttpStatus.OK);
	}
	

	@GetMapping("/getdatabyid")
	public ResponseEntity<Response> getUserById1(@RequestParam int id) {
		ResponseEntity<Response> response = new ResponseEntity<Response>(userService.getById(id), HttpStatus.OK);
		return response;
	}
	
}
