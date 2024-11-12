package com.vsr.demo.on.hibernate.repoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsr.demo.on.hibernate.entity.School;

@Repository
public interface ApiRepository extends JpaRepository<School, Integer>{

}
