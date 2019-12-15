package br.com.todospodemprogramar.app.repository;

import br.com.todospodemprogramar.app.model.User;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by Natalia Rosa on 08/07/19.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String username);
}
