package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.entities.Task;
import com.example.entities.User;
import com.example.services.TaskService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAdminTests {
	
      @Autowired
      private UserService userService;
      @Autowired
      private TaskService taskService;
       
      @Before
      public void initDb() {
    	  {
    		  User newUser = new User("user@mail.com", "user", "6752216");
    		  userService.createUser(newUser); 
    	  }
    	  {
    		  User newUser = new User("admin@mail.com", "admin", "224612");
    		  userService.createUser(newUser); 
    	  }
    	  
    	  Task userTask = new Task("09/09/2015", "00:11", "11:00", "Treba da se ide na put");
    	  User user = userService.findOne("user@mail.com");
    	  taskService.addTask(userTask, user);  
      }
	 
      @Test
      public void testUser() {
    	  User user = userService.findOne("user@mail.com");
          assertNotNull(user);
    	  User admin = userService.findOne("admin@mail.com");
    	  assertEquals(admin.getEmail(),"admin@mail.com");
      }
      
      @Test
      public void testTask() {
    	  User user = userService.findOne("user@mail.com");
    	  List<Task> task = taskService.findUserTask(user);
    	  assertNotNull(task); 

      }
      
      
      
     
	
}
