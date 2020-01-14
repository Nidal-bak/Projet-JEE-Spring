package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lieu implements Serializable {
	
	
	@Id
	private String codeInsee;
	private String nomCom ;
	private double longitude ;
	private double latitude ;
	@ManyToOne
	 @JoinColumn(name="FK_NumDep")
	private Departement dep;
	
	@OneToMany(mappedBy="localite",fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	private Collection<Monument> monuments;
	
	public Lieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lieu(String codeInsee, String nomCom, double longitude, double latitude, Departement dep) {
		super();
		this.codeInsee = codeInsee;
		
		this.nomCom = nomCom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.dep = dep;
	}


	public String getCodeInsee() {
		return codeInsee;
	}
	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getNomCom() {
		return nomCom;
	}
	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Departement getDep() {
		return dep;
	}

	public void setDep(Departement dep) {
		this.dep = dep;
	}

	public Collection<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(Collection<Monument> monuments) {
		this.monuments = monuments;
	}
	

}
