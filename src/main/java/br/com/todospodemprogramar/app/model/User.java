package br.com.todospodemprogramar.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by Natalia Rosa on 08/07/19.
 */
@Entity
@Table(name="user")
public class User {
	
	@Id
	private int id;
	private String username;
	private String name;
	private String experience;
	private String hobby;
	private String contact;
	private String password;
	
	public User(String username, String name, String experience, String hobby, String contact,
			String password) {
		super();
		this.username = username;
		this.name = name;
		this.experience = experience;
		this.hobby = hobby;
		this.contact = contact;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", experience=" + experience
				+ ", hobby=" + hobby + ", contact=" + contact + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id &&
				Objects.equals(username, user.username) &&
				Objects.equals(name, user.name) &&
				Objects.equals(experience, user.experience) &&
				Objects.equals(hobby, user.hobby) &&
				Objects.equals(contact, user.contact) &&
				Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, name, experience, hobby, contact, password);
	}

}
