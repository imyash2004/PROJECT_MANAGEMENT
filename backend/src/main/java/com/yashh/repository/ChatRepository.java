package com.yashh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashh.model.Chat;
import com.yashh.model.Project;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    

	Chat findByProject(Project projectById);
	
//	List<Chat> findByProjectNameContainingIgnoreCase(String projectName);
}

