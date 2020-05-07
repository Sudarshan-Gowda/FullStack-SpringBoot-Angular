package com.star.sud.webservices.todo.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "admin",
				"$2a$10$YRXpWqOokIuATk8vQrpMxuMN4NMdTrhJGxFwkwG87JCvKq7twVqVa", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(1L, "sudarshan",
				"$2a$10$M8YUa0tx6dUpARJFLMZnBO55sTTHTGvIh.tTGCRJ0dPjL7iBenD76", "ROLE_USER_2"));
		//Original Password - Password123!
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
