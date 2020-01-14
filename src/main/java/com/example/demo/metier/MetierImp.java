package com.example.demo.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Dao.CelebriteRepository;
import com.example.demo.Dao.DepartementRepository;
import com.example.demo.Dao.LieuRepository;
import com.example.demo.Dao.MonumentRepository;
import com.example.demo.entity.Celebrite;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Lieu;
import com.example.demo.entity.Monument;
@Service
@Transactional
public class MetierImp implements IMetier {
	@Autowired
	private CelebriteRepository celebriteRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private LieuRepository lieuRepository;
	@Autowired
	private MonumentRepository monumentRepository;
	
	@Override
	public Lieu addLieu(Lieu l) {
		lieuRepository.save(l);
		return l;
	}

	@Override
	public Departement addDepartement(Departement d) {
		departementRepository.save(d);
		return d;
	}

	@Override
	public Monument addMonument(Monument m) {
		monumentRepository.save(m);
		return m;
	}

	@Override
	public Celebrite addCelebrite(Celebrite c) {
		celebriteRepository.save(c);
		return c;
	}

	@Override
	public Departement getDepartement(String dep) {
		return departementRepository.getDepartement(dep);
	}
	
	@Override
	public Celebrite getCelebrite(Integer numCelebrite) {
		return celebriteRepository.getCelebrite(numCelebrite);
	}
	
	@Override
	public Monument getMonument(String codeM) {
		return monumentRepository.getMonument(codeM);
	}
	
	@Override
	public Lieu getLieu(String codeInsee)
	{
		return lieuRepository.getLieu(codeInsee);
	}
	@Override
	public List<Departement> getListDepartements() {
		List<Departement> req = departementRepository.findAll();
		return req;	
	}

	@Override
	public List<Lieu> getListLieux() {
		List<Lieu> req = lieuRepository.findAll();
		return req;
	}

	@Override
	public void deleteLieu(String codeInsee) {
		
		Lieu l=lieuRepository.getLieu(codeInsee);
		
		lieuRepository.delete(l);
	}

	@Override
	public void addMonumentToLieu(String codeM, String codeInsee) {
		Monument m = monumentRepository.getMonument(codeM);
		Lieu l = lieuRepository.getLieu(codeInsee);
		l.getMonuments().add(m);
	}

	@Override
	public double getDistanceBetweenMonuments(String codeMA, String codeMB) {
		double distance = 0;
		double x = 111.16;
		Monument m1 = monumentRepository.getMonument(codeMA);
		Monument m2 = monumentRepository.getMonument(codeMB);
		double diffLong = m1.getLongitude()- m2.getLongitude();
		double diffLat = m1.getLatitude() - m2.getLatitude();
		distance = Math.sqrt((diffLong*diffLong)+(diffLat*diffLat))*x;
		return distance;
	}

	@Override
	public Collection<Monument> getListMonumentsByDep(String dep) {
		Departement d = departementRepository.getDepartement(dep);
		Collection<Lieu> l = d.getLieux();
		Collection<Monument> res = new ArrayList<>();
		for(Lieu c:l)
			for(Monument m:c.getMonuments())
				res.add(m);			
		return res;
	}

	@Override
	public Collection<Monument> getListMonumentsByLieu(String codeInsee) {
		Lieu l = lieuRepository.getLieu(codeInsee);
		return l.getMonuments();
	}

	@Override
	public void deleteDepartement(String dep) {
		Departement d = departementRepository.getDepartement(dep);
		departementRepository.delete(d);
		
	}

	@Override
	public void addCelebriteToMonument(Integer numCelebrite, String codeM) {
		Monument m = monumentRepository.getMonument(codeM);
		Celebrite c = celebriteRepository.getCelebrite(numCelebrite); 
		c.getMonuments().add(m);
		m.getCelebrites().add(c);
		//celebrite.getMonuments().add(monument);
		//monument.getCelebrites().add(celebrite);
		//Collection<Monument> res = celebrite.getMonuments();
		//Collection<Celebrite> tas = monument.getCelebrites();
		//res.add(monument);
		//tas.add(celebrite);
	}

	@Override
	public Celebrite getCelebritebyname(String nom) {
		
		return celebriteRepository.getCelebritebyname(nom);
	}

	@Override
	public Monument getMonumentbyname(String nomM) {
		return monumentRepository.getMonumentbyname(nomM);
	}

	

}
