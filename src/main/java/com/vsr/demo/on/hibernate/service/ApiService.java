package com.vsr.demo.on.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsr.demo.on.hibernate.entity.Principal;
import com.vsr.demo.on.hibernate.entity.School;
import com.vsr.demo.on.hibernate.entity.Student;
import com.vsr.demo.on.hibernate.repoo.ApiRepository;

@Service
public class ApiService {
	
	@Autowired
	private ApiRepository repo;

	public void excute() {
	School  school = new School();
	Principal principal = new Principal();
	principal.setName("XYZ");
	List<Student> studs = new ArrayList<>();
	Student stud = new Student();
	stud.setName("vsr");
	studs.add(stud);
	
	school.setName("GOVT");
	school.setPrincipal(principal);
	school.setStudents(studs);
	
		repo.save(school);
	}

}
