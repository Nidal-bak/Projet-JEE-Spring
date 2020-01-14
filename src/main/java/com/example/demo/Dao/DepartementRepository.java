package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, String>{
	
	@Query("select d from Departement d where d.dep=:x")
	public Departement getDepartement(@Param("x")String dep);
	//@Modifying
	//@Query("delete from Departement b where b.dep=:x")
	//public void deleteDepartement(@Param("x")String dep);

}
