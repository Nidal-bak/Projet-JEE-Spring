package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Monument;
public interface MonumentRepository extends JpaRepository<Monument, String> {
	@Query("select m from Monument m where m.codeM=:x")
	public Monument getMonument(@Param("x")String codeM);
	@Query("select m from Monument m where m.nomM=:x")
	public Monument getMonumentbyname(@Param("x")String nomM);
}
