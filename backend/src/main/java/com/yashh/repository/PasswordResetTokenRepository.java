package com.yashh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashh.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
