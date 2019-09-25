package com.example.repositories;

import java.util.List;

import com.example.entities.Task;
import com.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user); 
	
}
