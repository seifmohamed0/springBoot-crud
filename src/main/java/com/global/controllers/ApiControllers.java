package com.global.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.models.User;
import com.global.repos.UserRepo;

@RestController
public class ApiControllers {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String sayHello() {
		return "hello";
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "saved...";  	
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable Long id , @RequestBody User user) {
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setAge(user.getAge());
		userRepo.save(updatedUser);
		return "user updated...";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		User deletedUser = userRepo.findById(id).get();
		userRepo.delete(deletedUser);
		return "user deleted....";
	}

	
}
