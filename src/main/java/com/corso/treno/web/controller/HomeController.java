package com.corso.treno.web.controller;

import java.io.IOException;


import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import builder.TrenoBuilder;
import builder.TN.TNBuilder;
import dao.*;
import daoImpl.*;
import dto.TrenoDTO;
import dto.UtenteDTO;
import exception.Errori;
import treno.Treno;


@Controller
public class HomeController {

	// modifica da cancellare
	
	@RequestMapping(path = "/")
	public String home() {
		return "Home";
	}
	//ciao sto bene
	@GetMapping(path = "/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping(path = "/altraprova")
	public String altraprova() {
		return "altraprova";
	}
	@RequestMapping(path = "/CreazioneTreno")
	public String altraprova1() {
		return "CreazioneTreno";
	}

	@RequestMapping(path = "/register")
	public String register(@WebParam String username, @WebParam String password, Model model) {

		UtenteDao utenteDAO = UtenteDaoImpl.getInstance();
		try {
			utenteDAO.add(username, password);
			model.addAttribute("username", username);
			model.addAttribute("password", password);
		return "Register";
		}
		catch (Exception e) {
			model.addAttribute("erroreRegister", e.getMessage());
			return "erroreRegistrazione";
		}
		

	}

	@RequestMapping(path = "/login")
	public String login(@WebParam String username, @WebParam String password, Model model,HttpServletRequest request) {

		UtenteDao utenteDAO = UtenteDaoImpl.getInstance();

		if (utenteDAO.findByUsernameEPassword(username,password) != null ) {
			model.addAttribute("username", username);
			request.getSession().setAttribute(username, username);
			System.out.println(utenteDAO.findByUsername(username));
			return "Menu";
		} else
			return "loginfallito";
	}

	@RequestMapping(path = "/registrazioneeffettuata")
	public String registrazioneeffettuata() {
		return "logineffettuato";
	}
	
	@RequestMapping(path = "/costruisci")
	public String costruisci(@WebParam String sigla, Model model, HttpServletRequest request) throws IOException {
		String username=(String) request.getSession().getAttribute("username");
		Errori e1 = new Errori(sigla);
		try {
			TrenoBuilder trenoTN = new TNBuilder();
			Treno treno = trenoTN.costruisci(sigla);
			System.out.println(treno);
			
			
			TrenoDao trenoDAO = TrenoDaoImpl.getInstance();
			UtenteDao utenteDAO = UtenteDaoImpl.getInstance();
		
			trenoDAO.add(treno, utenteDAO.findByUsername(username));
		
			
			
				List<String> trenoSigla = new LinkedList<String>();
//				File locomotiva=new File("C:/Users/miste/eclipse-workspace/WebAppTreno2/src/main/webapp");
				String locomotiva = "<img src='./img/locomotiva.png' width='150'>";			
				String passeggeri = "<img src='./img/passeggeri.png' width='150'>";
				String ristorante = "<img src='./img/ristorante.png' width='150' >";
				String cargo = "<img src='./img/cargo.png' width='150'>";
//				File passeggeri=new File("C:/Users/miste/eclipse-workspace/WebAppTreno2/src/main/webapp");
//				File ristorante=new File("C:/Users/miste/eclipse-workspace/WebAppTreno2/src/main/webapp");
//				File cargo=new File("C:/Users/miste/eclipse-workspace/WebAppTreno2/src/main/webapp");
				for(int i = 0; i<sigla.length(); i++) {
					switch(sigla.charAt(i)) {
					case 'H':
						trenoSigla.add(locomotiva);
						break;
					case 'P':
						trenoSigla.add(passeggeri);
						break;
					case 'R':
						trenoSigla.add(ristorante);
						break;
					case 'C':
						trenoSigla.add(cargo);
						break;
					}
					model.addAttribute("trenoSigla",prova(trenoSigla));
					model.addAttribute("sigla",sigla);
				}
		}catch (Exception e) {
				model.addAttribute("errore",e1.getMessage(sigla));
				model.addAttribute("siglaSuggerita",e1.siglaSuggerita(sigla));
		}
		
		return "costruisci";
	}
	
	
	
	
	@RequestMapping(path = "/treni")
	public String treni( Model model, HttpServletRequest request) {	
		String username=(String) request.getSession().getAttribute("username");
		TrenoDao trenoDAO = TrenoDaoImpl.getInstance();
		
		List<TrenoDTO> listaTreniUtente = new ArrayList<>();
		List<String> trenoSigla = new LinkedList<String>();
		
		String locomotiva = "<img src='./img/locomotiva.png' width='150'>";			
		String passeggeri = "<img src='./img/passeggeri.png' width='150'>";
		String ristorante = "<img src='./img/ristorante.png' width='150' >";
		String cargo = "<img src='./img/cargo.png' width='150'>";
		
		for(TrenoDTO t : trenoDAO.listaTreni()) {
			if (t.getUtente().getUsername().equals(username)){
				System.out.println(t);
				for(int i = 0; i<t.getSigla().length(); i++) {
					List<String> sigla = new LinkedList<String>();
					switch(t.getSigla().charAt(i)) {
					case 'H':
						trenoSigla.add("<p id='lt'>"+t.getSigla()+"</p>");
						trenoSigla.add("<br>");
						trenoSigla.add(locomotiva);
						break;
					case 'P':
						trenoSigla.add(passeggeri);
						break;
					case 'R':
						trenoSigla.add(ristorante);
						break;
					case 'C':
						trenoSigla.add(cargo);
						break;
					}
				
				listaTreniUtente.add(t);
				
			}
				
				trenoSigla.add("<br>");
		}
		}
		
		model.addAttribute("trenoSigla", prova(trenoSigla));
		model.addAttribute("listaTreni", listaTreniUtente);
		
		
		
		return "treni";
	}
	public static String prova(List list){
		String finale="";
		for(int i = 0; i<list.size(); i++) {
			finale=finale+"   "+list.get(i)+"   ";
		}
		return finale;
		
	}
}
