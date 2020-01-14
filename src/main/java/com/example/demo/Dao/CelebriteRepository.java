package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Celebrite;

public interface CelebriteRepository extends JpaRepository<Celebrite, Integer> {
	@Query("select c from Celebrite c where c.numCelebrite=:x")
	public Celebrite getCelebrite(@Param("x")Integer numCelebrite);
	@Query("select c from Celebrite c where c.nom=:x")
	public Celebrite getCelebritebyname(@Param("x")String nom);

}
