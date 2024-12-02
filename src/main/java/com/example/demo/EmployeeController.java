package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepos repo;
	@RequestMapping("/emp")
	public String show() {
	return "EmpInfo";
	}
	@RequestMapping("/insert")
	public String show1() {
	return "InsertEmp";
	}
	@RequestMapping("/insemp")
	public String show(EmpRec emp) {
	repo.save(emp);
	System.out.println("Record Inserted");
	return "EmpInfo";
	}
	@RequestMapping("/select")
	public String show2() {
	return "SelectEmp";
	}
	@RequestMapping("/selemp")
	@ResponseBody
	public EmpRec show3(@RequestParam("empid")int empid) {
	return repo.findById(empid).orElse(null);
	}
	@RequestMapping("/showall")
	@ResponseBody
	public List<EmpRec> show4() {
	return repo.findAll();
	}
	}