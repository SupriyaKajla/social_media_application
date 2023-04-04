package com.springboot.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Priya", LocalDate.now().minusYears(20)));
		users.add(new User(2, "Riya", LocalDate.now().minusYears(20)));
		users.add(new User(3, "Pria", LocalDate.now().minusYears(20)));
		users.add(new User(4, "Piya", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findUsers(){
		return users;
	}
	
	public User findUser(Integer id ) {

		Predicate<? super User> predicate = user -> user.getId().equals(id)   ;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User addUser(User user) {
		users.add(user) ;
		return user;
	}
	
	public void deleteById(Integer id ) {

		Predicate<? super User> predicate = user -> user.getId().equals(id)   ;
		users.removeIf(predicate);
	}
	

}
