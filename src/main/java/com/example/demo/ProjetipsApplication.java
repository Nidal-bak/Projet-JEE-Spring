package com.example.demo;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Dao.CelebriteRepository;
import com.example.demo.Dao.DepartementRepository;
import com.example.demo.Dao.LieuRepository;
import com.example.demo.Dao.MonumentRepository;
import com.example.demo.entity.Celebrite;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Lieu;
import com.example.demo.entity.Monument;
import com.example.demo.metier.IMetier;

@SpringBootApplication
public class ProjetipsApplication implements CommandLineRunner {
	@Autowired
	private CelebriteRepository celebriteRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private LieuRepository lieuRepository;
	@Autowired
	private MonumentRepository monumentRepository;
	@Autowired
	private IMetier imetier; 

	public static void main(String[] args) {
		SpringApplication.run(ProjetipsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(imetier.getMonumentbyname("fff").getNomM());
		//System.out.println(imetier.getCelebritebyname("nidal").getNom());
		//System.out.println(imetier.getDistanceBetweenMonuments("ee", "aa"));
		//imetier.addCelebriteToMonument(1,"ee");
		//imetier.deleteLieu("toto");
		/*
		Celebrite c1=celebriteRepository.save(new Celebrite(1,"nidal", "bek", "Maroc", "x"));
		Celebrite c2=celebriteRepository.save(new Celebrite(2,"kamal", "sad", "Maroc", "y"));
		Celebrite c3=celebriteRepository.save(new Celebrite(3,"saad", "grf", "Maroc", "t"));
		Celebrite c4=celebriteRepository.save(new Celebrite(4,"anas", "aaa", "Maroc", "aa"));
		Departement d1=departementRepository.save(new Departement("occi", "nancy", "occitanie", "mnt"));
		Departement d2=departementRepository.save(new Departement("nor", "oma", "nord", "bkh"));
		Lieu l1=lieuRepository.save(new Lieu("fgh", "grr", 400, 200,d1));
		Lieu l2=lieuRepository.save(new Lieu("pjd", "ert", 400, 200,d2));
		Monument m1=monumentRepository.save(new Monument("ee", "fff", "uhu", "dlgm", 333, 542, l1));
		Monument m2=monumentRepository.save(new Monument("aa", "ccc", "mlk", "ygb", 654, 321, l2));
		Monument m3= new Monument("Nidal", "fff", "uhu", "dlgm", 333, 542, l1);
		
		
		Celebrite a = imetier.getCelebrite(1);
		System.out.println(a.getNom());
		Monument b= imetier.getMonument("ee");
		System.out.println(b.getNomM());
		*/
		
		//imetier.addCelebriteToMonument(c2, m1);
		//imetier.addMonument(m3);
		
		// imetier.getListLieux();
		// imetier.getListDepartements();
		//System.out.println(departementRepository.getOne("occi").getNomDep());
		//System.out.println(imetier.getDepartement("occi").getNomDep());
		//List<Departement> list;
		//list=imetier.getListDepartements();
		//for(Departement d:list)
			//System.out.println(d.getNomDep());
		//imetier.deleteLieu("fgh");
		//imetier.addMonumentToLieu("ee","pjd");
		//Collection<Monument> lst = l2.getMonuments();
		//for(Monument m:lst)
		//System.out.println(m.getCodeM());
		//System.out.println(imetier.getDistanceBetweenMonuments("ee", "aa"));
		
		
		
		
		//System.out.println(lieuRepository.getLieu("fgh").getNomCom());
		
		//imetier.deleteLieu("fgh");
		
		
			
			
		
		
		//imetier.getDepartement("occi");
		//imetier.deleteLieu("fgh");
		
		
		
		
		
		
	}

}
