package com.yashh.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yashh.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
