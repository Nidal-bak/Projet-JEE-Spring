package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {
	@Id
	private String dep;
	private String chefLieu ;
	private String nomDep ;
	private String reg ;
	
	@OneToMany(mappedBy="dep",fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	private Collection<Lieu> lieux;
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Departement(String dep, String chefLieu, String nomDep, String reg) {
		super();
		this.dep = dep;
		this.chefLieu = chefLieu;
		this.nomDep = nomDep;
		this.reg = reg;
		
	}


	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getChefLieu() {
		return chefLieu;
	}
	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}


	public Collection<Lieu> getLieux() {
		return lieux;
	}


	public void setLieux(Collection<Lieu> lieux) {
		this.lieux = lieux;
	}
    
}
