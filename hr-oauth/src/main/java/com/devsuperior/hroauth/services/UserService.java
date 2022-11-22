package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.clients.UserFeignClient;

import static com.devsuperior.hroauth.util.LoggingUtil.error;
import static com.devsuperior.hroauth.util.LoggingUtil.info;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			error(this.getClass(), "Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		info(this.getClass(), "Email found: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			error(this.getClass(), "Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		info(this.getClass(), "Email found: " + username);
		return user;
	}
}
