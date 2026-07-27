package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Admin;
import com.business.entities.User;
import com.business.repositories.UserRepository;
@Component
public class UserServices 
{
	@Autowired
	private UserRepository userRepository;
		
	// Get all users.
	public List<User> getAllUser()
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		return users;
	}
	
	// Get a single user by id.
	public User getUser(int id)
	{
		Optional<User> optional = this.userRepository.findById(id);
		User user = optional.get();
		return user;
	}
	
	// Get a single user by email.
	public User getUserByEmail(String email)
	{
	 User foundUser = this.userRepository.findUserByUemail(email);
	 return foundUser;
	}
	
	// Update a user.
	public void updateUser(User user,int id)
	{
		user.setU_id(id);
		 this.userRepository.save(user);
	}
	
	// Delete a single user.
	public void deleteUser(int id)
	{
		this.userRepository.deleteById(id);
	}

	// Add a user.
	public void addUser(User user)
	{
	this.userRepository.save(user);
	}
	
	// Validate login credentials.
	public boolean validateLoginCredentials(String email, String password)
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		for (User currentUser : users)
		{
		if (currentUser != null && currentUser.getUpassword().equals(password) && currentUser.getUemail().equals(email))
		{
			return true;
		}
		}
		return false;
	}
	
	

}
