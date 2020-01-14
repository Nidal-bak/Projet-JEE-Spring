package com.example.demo.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.FilterJoinTable;

@Entity
public class Celebrite implements Serializable {
	
	@Id 
	private Integer numCelebrite;
	private String nom;
	private String prenom;
	private String nationalite;
	private String epoque;
	@ManyToMany
	@JoinTable(name = "AssocieA", inverseJoinColumns= {@JoinColumn(name="codeM")}, joinColumns = {@JoinColumn(name="numCelebrite")})
	private Collection<Monument> monuments = new ArrayList<>();
	
	public Celebrite(Integer numCelebrite, String nom, String prenom, String nationalite, String epoque) {
		super();
		this.numCelebrite= numCelebrite;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
	}
	public Celebrite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public Collection<Monument> getMonuments() {
		return monuments;
	}
	public void setMonuments(Collection<Monument> monuments) {
		this.monuments = monuments;
	}
	public String getEpoque() {
		return epoque;
	}
	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}
	
	public Integer getNumCelebrite() {
		return numCelebrite;
	}
	public void setNumCelebrite(Integer numCelebrite) {
		this.numCelebrite = numCelebrite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


}