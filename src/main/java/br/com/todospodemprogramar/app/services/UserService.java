package br.com.todospodemprogramar.app.services;

import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Created by Natalia Rosa on 08/07/19.
 */
@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public User saveMyUser(User user ) {
		return userRepository.save(user);
	}
	
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		for(User user : userRepository.findAll()) {
			users.add(user);
		}
		
		return users;
	}
	
	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> editUser(int id) {
		return userRepository.findById(id);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	public User findByUsername(String string) {
		return userRepository.findByUsername(string);
	}
	
	public Optional<User> findUser(int id) {
		Optional<User> user = null;
		user = userRepository.findById(id);
		return user;
	}
	
	
	}

	