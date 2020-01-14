package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Monument implements Serializable {
	
	@Id
	private String codeM;
	private String nomM ;
	private String proprietaire ;
	private String typeMonument ;
	private double longitude ;
	private double latitude ;
	@ManyToOne
	 @JoinColumn(name="FK_CodeInsee")
	private Lieu localite;
	@ManyToMany(mappedBy = "monuments")
	private Collection<Celebrite> celebrites = new ArrayList<>();
    
	
	public Monument(String codeM, String nomM, String proprietaire, String typeMonument, double longitude,
			double latitude, Lieu localite) {
		super();
		this.codeM = codeM;
		this.nomM = nomM;
		this.proprietaire = proprietaire;
		this.typeMonument = typeMonument;
		this.longitude = longitude;
		this.latitude = latitude;
		this.localite = localite;
		
	}
	public Monument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Celebrite> getCelebrites() {
		return celebrites;
	}
	public void setCelebrites(Collection<Celebrite> celebrites) {
		this.celebrites = celebrites;
	}
	public String getCodeM() {
		return codeM;
	}
	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}
	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getTypeMonument() {
		return typeMonument;
	}
	public void setTypeMonument(String typeMonument) {
		this.typeMonument = typeMonument;
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
	public Lieu getLocalite() {
		return localite;
	}
	public void setLocalite(Lieu localite) {
		this.localite = localite;
	}

	

}

