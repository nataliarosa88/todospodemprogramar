package br.com.todospodemprogramar.app.services;

import br.com.todospodemprogramar.app.exception.EntityNotFoundException;
import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

	public User save(User user) throws EntityNotFoundException { // NOSONAR
		return userRepository.save(user);
	}

}