package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.UserRepository;
import security.LoginService;
import domain.User;

@Service
@Transactional
public class UserService {
	
	// Managed repository --------------------
	@Autowired
	private UserRepository userRepository;
	
	
	// Simple CRUD methods ----------
	public User save(User user){
		return userRepository.save(user);
	}
	
	public Collection<User>  findAll(){
		return userRepository.findAll();
	}
	
	public User findOne(Integer valueOf) {
		return userRepository.findOne(valueOf);
	}
	
	//Other business methods -------------------
	public User findByPrincipal() {
		return userRepository.findOneByPrincipal(LoginService.getPrincipa().getId());
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}