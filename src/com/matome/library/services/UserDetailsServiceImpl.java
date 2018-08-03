package com.matome.library.services;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.matome.library.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.matome.library.model.Student user = userRepository.findByUserName(username);
		
		if (user == null) {
		  throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), emptyList());
	}

		

}
