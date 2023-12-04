package com.codewithrajeev.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithrajeev.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
	private UserRepo userRepo;
	

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void repoTest() {
		String className = this.userRepo.getClass().getName();
		String packName  = this.userRepo.getClass().getPackageName();
		System.out.println(className);    								// jdk.proxy2.$Proxy107
		System.out.println(packName);     								// jdk.proxy2 		
		
	}
	
	

}



/* How we  autowire interface?
 * Repo is interface extending jpa repository. We are not providing implementation for repo interface then how we are
 * able to autowire repo in service class?
 * 
 * 
 * We know, When autowiring happens always  object of class comes
 * 
 * When spring container starts, then all the repo interface are scanned and dynamically 
 * on runtime implementation class is provided for all  repo interface.  Those classes are 
 * called proxy classes.
 *  
 */
