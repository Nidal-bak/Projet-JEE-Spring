package com.example.demo.web;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Celebrite;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Lieu;
import com.example.demo.entity.Monument;
import com.example.demo.metier.IMetier;

@Controller
public class ApliController {
	@Autowired
	private IMetier imetier;
	
	@RequestMapping(value="/")
	 public String home() {
		 
		 return "redirect:/acceuil";
	 }
	
	@RequestMapping("/celebrites")
	public String index() 
	{
		return "celebrites"; }
	
	@RequestMapping("/acceuil")
	public String index5() 
	{
		return "acceuil"; }
	
	@RequestMapping("/Lieux")
	public String index2(Model model) 
	{
		List<Lieu> ListLieux = imetier.getListLieux();
		model.addAttribute("ListLieux",ListLieux);
		return "Lieux"; }
	
	@RequestMapping("/monuments")
	public String index3() 
	{
		return "monuments"; }
	
	@RequestMapping("/departements")
	public String index4() 
	{
		return "departements"; }
	
	@RequestMapping("/consultcelebrite")
	public String consultercelebrite(Model model,String nomcelebrite) 
	{
		try {
		Celebrite c =imetier.getCelebritebyname(nomcelebrite);
		Collection<Monument>  ListMonuments = c.getMonuments();
		model.addAttribute("ListMonuments",ListMonuments);
		model.addAttribute("celebrite", c);
		    }catch(Exception e) {
		    	model.addAttribute("exception", e);
		    }
		
		return "celebrites"; }
	
	@RequestMapping("/consultmonument")
	public String consultermonument(Model model,String nomM) 
	{
		try {
		Monument m =imetier.getMonumentbyname(nomM);
		model.addAttribute("monument", m);
		    }catch(Exception e) {
		    	model.addAttribute("exception1", e);
		    }
		
		return "monuments"; }
	
	@RequestMapping("/consultdepartement")
	public String consultercmt(Model model,String codedepartement) 
	{
		try {
		Departement d=imetier.getDepartement(codedepartement);
		Collection<Lieu> ListLieux = d.getLieux();
		Collection<Monument>  ListMonuments = imetier.getListMonumentsByDep(codedepartement);
		model.addAttribute("ListLieux",ListLieux);
		model.addAttribute("ListMonuments",ListMonuments);
		model.addAttribute("departement", d);
		    }catch(Exception e) {
		    	model.addAttribute("exception", e);
		    }
		
		return "departements"; }
	
	@RequestMapping(value="/ajouterLieu",method=RequestMethod.POST)
	public String ajoutlieu(Model model,String codeInsee, String nomCom,double longitude,double latitude, String dep) 
	{
		try {
		Departement d=imetier.getDepartement(dep);
		if(d != null) {
	    Lieu l=new Lieu(codeInsee,nomCom,longitude,latitude,d);
		imetier.addLieu(l);}
		else {
			String a = "erreur";
	    	model.addAttribute("erreur", a);
	    }
			
		}catch(Exception e) {
	    	model.addAttribute("erreur", e);
	    }
		return "redirect:/Lieux"; }
	 
	@RequestMapping("/suprimerLieu")
	public String suprimerlieu(String codeLieu)
	{
		imetier.deleteLieu(codeLieu);
	return "redirect:/Lieux";}
	
	@RequestMapping("/addCelebritetomonument")
	
	public String addCetoMo(Model model,Integer numCelebrite, String codeM)
	{
		try {
		imetier.addCelebriteToMonument(numCelebrite, codeM);
		}catch(Exception e) {
	    	model.addAttribute("exception3", e);
	    }
	return "monuments";}
	
	@RequestMapping("/calculdistance")
	public String consulterdistance(Model model,String codeM1,String codeM2) 
	{
		try {
		double distance = imetier.getDistanceBetweenMonuments(codeM1, codeM2);
		model.addAttribute("distance", distance);
		}catch(Exception e) {
	    	model.addAttribute("exception2", e);
	    }
		return "monuments"; }
	
	@RequestMapping(value="/403")
	 public String accessDenied() {
		 
		 return "403";
	 }
	@RequestMapping(value="/modifier")
	public String modifierlieu(String codeInsee,Model model) {
		 Lieu Lieu = imetier.getLieu(codeInsee);
		 model.addAttribute("Lieu", Lieu);
		 return "modifierlieu"; }
	
	
}
