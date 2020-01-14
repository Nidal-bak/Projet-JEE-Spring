package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Lieu;

public interface LieuRepository extends JpaRepository<Lieu, String>{
	@Query("select l from Lieu l where l.codeInsee=:x")
	public Lieu getLieu(@Param("x")String codeInsee);
	

}
