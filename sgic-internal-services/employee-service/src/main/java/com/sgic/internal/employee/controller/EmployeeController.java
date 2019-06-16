package com.sgic.internal.employee.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.employee.controller.dto.EmployeeData;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.services.EmployeeService;
import com.sgic.internal.employee.services.impl.EmployeeServiceImpl;


@RestController
public class EmployeeController 
{
	@SuppressWarnings("unused")
	private static Logger logger=LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	  @PostMapping(value = "/employee")
	  public ResponseEntity<Object> createGrampa(@RequestBody EmployeeData employeeData) {
		logger.info("saving:"+employeeData.getClass());
	    Employee employee =new Employee();
	    employee.setEmail(employeeData.getEmail());
	    employee.setFirstName(employeeData.getFirstName());
	    employee.setLastName(employeeData.getLastName());
	    employeeService.createEmployee(employee);
	    
	    return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	   
	  }
	  
	  @GetMapping(value="/getAllemployee")
	 public List<Employee>getAllemployee(){
		  logger.info("Getting");
		  return employeeService.getAllemployee();
	  }
	  
}

