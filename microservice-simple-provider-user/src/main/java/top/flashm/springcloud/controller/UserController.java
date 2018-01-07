package top.flashm.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import top.flashm.springcloud.entity.User;
import top.flashm.springcloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("{id}")
	public User findById(@PathVariable Long id){
		User user = userRepository.findOne(id);
		return user;
	}
}
