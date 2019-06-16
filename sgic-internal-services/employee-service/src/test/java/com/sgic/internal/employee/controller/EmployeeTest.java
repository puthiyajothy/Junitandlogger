package com.sgic.internal.employee.controller;

import com.sgic.internal.employee.EmployeeApplicationTests;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;


public class EmployeeTest  extends EmployeeApplicationTests{
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  @Before
	  public void setup() {
	  String newUser = "INSERT INTO employeeservice.employee (email, first_name, last_name) VALUES ('ty', 'ede', 'ee')";
	  jdbcTemplate.execute(newUser);
	  }

	  @Test
	  public void getEmployeeSuccessfull() throws IOException, RestClientException {
	    ResponseEntity<String> response =
	        testRestTemplate.exchange("http://localhost:8081/employeeservice" + "/getAllemployee", HttpMethod.GET,
	            new HttpEntity<>(httpHeaders), String.class);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	   }
	  	  
	  
	  
	  @After
	  public void tearDown() {

	  }
	  public final class EmployeeConstant{
		    
		    public EmployeeConstant() {
		    }
		    
		    private static final String MAINCLASSIFICATION_RESPONSE =
		    		"[ { \\\"id\\\": 1, \\\"firstName\\\": \\\"Ty\\\", \\\"lastName\\\": \\\"ede\\\", \\\"email\\\": \\\"ee\\\" } ]";
		  }
	  

}
