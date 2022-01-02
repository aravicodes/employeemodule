package com.cg.bugtracking.employee.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.bugtracking.employee.dto.EmployeeDto;
import com.cg.bugtracking.employee.entity.Bug;
import com.cg.bugtracking.employee.entity.Employee;
import com.cg.bugtracking.employee.service.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class EmployeeController {
	@Autowired
	IEmployeeService es;
	
	@ApiOperation("Used to fetch all employees")
	@GetMapping("/employees")
	public List<EmployeeDto> allemployees(){
		return es.getAllEmployees();		
	}
	@ApiOperation("Used to fetch employee with particular id")
	@GetMapping("/employees/{empId}")
	public EmployeeDto getemployee(@PathVariable long empId) {
		return es.getEmployee(empId);
	}
	@ApiOperation("Used to delete employee with particular id")
	@DeleteMapping("/employees/{empId}")
	public EmployeeDto deleteemployee(@PathVariable long empId) {
		return es.deleteEmployee(empId);
	}
	
	@ApiOperation("Used to create employee")
	@PostMapping("/employees")
	public EmployeeDto createemployee(@Valid @RequestBody EmployeeDto employeeDto){
		return es.createEmployee(employeeDto);	
	}
	
	@ApiOperation("Used to update employees")
	@PutMapping("/employees")
	public EmployeeDto updateemployee(@RequestBody EmployeeDto employeeDto){
		return es.updateEmployee(employeeDto);		
	}	
	
}
