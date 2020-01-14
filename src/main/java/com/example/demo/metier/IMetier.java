package com.example.demo.metier;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Celebrite;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Lieu;
import com.example.demo.entity.Monument;

public interface IMetier {
	
	public Lieu addLieu(Lieu l);
	public Departement addDepartement(Departement d);
	public Monument addMonument(Monument m);
	public Celebrite addCelebrite(Celebrite c);
	public Celebrite getCelebrite(Integer numCelebrite);
	public Celebrite getCelebritebyname(String nom);
	public Monument getMonument(String codeM);
	public Monument getMonumentbyname(String nomM);

	public Departement getDepartement(String numDep);
	public List<Departement> getListDepartements();
	
	public List<Lieu> getListLieux();
	public void deleteLieu(String codeInsee);
	public void deleteDepartement(String dep);

	public void addCelebriteToMonument(Integer numCelebrite, String codeM);
	public void addMonumentToLieu(String codeM, String codeInsee);
	public Lieu getLieu(String codeInsee);
	public double getDistanceBetweenMonuments(String CodeMA,String CodeMB);
	public Collection<Monument> getListMonumentsByDep(String dep);
	public Collection<Monument> getListMonumentsByLieu(String codeInsee);

}
