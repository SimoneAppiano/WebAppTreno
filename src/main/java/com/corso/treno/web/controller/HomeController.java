package com.corso.treno.web.controller;

import java.io.IOException;

import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.apache.maven.artifact.repository.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import builder.*;
import builder.TN.TNBuilder;
import dao.*;
import daoImpl.TrenoDaoImpl;
import daoImpl.UtenteDaoImpl;
import dto.TrenoDTO;
import exception.Errori;
import treno.Treno;

//prova

@Controller
public class HomeController {

	@RequestMapping(path = "/")
	public String boh(Model model) {
		int flag = 0;
		int j = 0;
		TrenoDao trenoDAO = TrenoDaoImpl.getInstance();

		List<TrenoDTO> listaTreniUtente = new ArrayList<>();
		List<String> trenoSigla = new LinkedList<String>();

		String locomotiva = "<img class='main-treno' src='./img/locomotivaV.png' width='150'>";
		String passeggeri = "<img class='main-treno' src='./img/passeggeriV.png' width='150'>";
		String ristorante = "<img class='main-treno' src='./img/ristoranteV.png' width='150' >";
		String cargo = "<img class='main-treno' src='./img/cargoV.png' width='150'>";
		List<TrenoDTO> l = trenoDAO.listaTreni() ;
				Collections.reverse(l);
				
		for (TrenoDTO t : l) {
			if (j == 5)
				break;
				for (int i = 0; i < t.getSigla().length(); i++) {
					List<String> sigla = new LinkedList<String>();
					switch (t.getSigla().toUpperCase().charAt(i)) {
					case 'H':
						trenoSigla.add("<p id='lt'>" + t.getSigla() + "</p>");
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
				j++;
		}

		model.addAttribute("trenoSigla", prova(trenoSigla));
		model.addAttribute("listaTreni", listaTreniUtente);
		model.addAttribute("flag", flag);
		return "Menu";
	}

	@RequestMapping(path = "/Home")
	public String home() {
		return "Home";
	}

	@RequestMapping(path = "/about")
	public String about(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		return "about";
	}


	@RequestMapping(path = "/CreazioneTreno")
	public String altraprova1() {
		return "CreazioneTreno";
	}

	@RequestMapping(path = "/register")
	public String register(@WebParam String username, @WebParam String password, Model model) {
		int flag=0;
		UtenteDao utenteDAO = UtenteDaoImpl.getInstance();
		model.addAttribute("Registrato", "Utente Registrato con Successo");
		model.addAttribute("erroreRegister", "Utente gia' registrato");
		try {
			utenteDAO.add(username, password);
			model.addAttribute("username", username);
			model.addAttribute("password", password);	
			flag=1;
			model.addAttribute("flag",flag);
		return "Home";
		}
		catch (Exception e) {
			e.getMessage();
			flag=2;
			model.addAttribute("flag",flag);
			return "Home";

		}

	}

	@RequestMapping(path = "/login")
	public String login(@WebParam String username, @WebParam String password, Model model, HttpServletRequest request) {
		int j = 0;
		request.getSession().setAttribute("username", username);
		UtenteDao utenteDAO = UtenteDaoImpl.getInstance();
		TrenoDao trenoDAO = TrenoDaoImpl.getInstance();
		List<TrenoDTO> listaTreniUtente = new ArrayList<>();
		List<String> trenoSigla = new LinkedList<String>();

		String locomotiva = "<img class='main-treno' src='./img/locomotivaV.png' width='150'>";
		String passeggeri = "<img class='main-treno' src='./img/passeggeriV.png' width='150'>";
		String ristorante = "<img class='main-treno' src='./img/ristoranteV.png' width='150' >";
		String cargo = "<img class='main-treno' src='./img/cargoV.png' width='150'>";
		List<TrenoDTO> l = trenoDAO.listaTreni() ;
		Collections.reverse(l);
		for (TrenoDTO t : l) {
			
			if (j == 5)
				break;
				for (int i = 0; i < t.getSigla().length(); i++) {
					List<String> sigla = new LinkedList<String>();
					switch (t.getSigla().toUpperCase().charAt(i)) {
					case 'H':
						trenoSigla.add("<p id='lt'>" + t.getSigla() + "</p>");
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
				j++;
			
		}

		model.addAttribute("trenoSigla", prova(trenoSigla));
		model.addAttribute("listaTreni", listaTreniUtente);

		int flagLogin=0;
		model.addAttribute("erroreLogin", "Utente non registrato");
		int flag = 1;
		if (utenteDAO.findByUsernameEPassword(username,password)) {
			model.addAttribute("flag", flag);

			model.addAttribute("username", username);
			request.getSession().setAttribute(username, username);
			System.out.println(utenteDAO.findByUsername(username));
			return "Menu";
		} else {
			flagLogin=1;
			model.addAttribute("flagLogin", flagLogin);
			return "Home";
		}
			}





	@RequestMapping(path = "/Menu")
	public String Menu(@WebParam Model model, HttpServletRequest request) {
		int flag = 1;
		int j = 0;
		String username = (String) request.getSession().getAttribute("username");
		
		TrenoDao trenoDAO = TrenoDaoImpl.getInstance();

		List<TrenoDTO> listaTreniUtente = new ArrayList<>();
		List<String> trenoSigla = new LinkedList<String>();

		String locomotiva = "<img class='main-treno' src='./img/locomotivaV.png' width='150'>";
		String passeggeri = "<img class='main-treno' src='./img/passeggeriV.png' width='150'>";
		String ristorante = "<img class='main-treno' src='./img/ristoranteV.png' width='150' >";
		String cargo = "<img class='main-treno' src='./img/cargoV.png' width='150'>";
		List<TrenoDTO> l = trenoDAO.listaTreni() ;
				Collections.reverse(l);
				
		for (TrenoDTO t : l) {
			if (j == 5)
				break;
				for (int i = 0; i < t.getSigla().length(); i++) {
					List<String> sigla = new LinkedList<String>();
					switch (t.getSigla().charAt(i)) {
					case 'H':
						trenoSigla.add("<p id='lt'>" + t.getSigla() + "</p>");
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
				j++;
		}
		model.addAttribute("trenoSigla", prova(trenoSigla));
		model.addAttribute("listaTreni", listaTreniUtente);
		
		
		if (username != null) {
			model.addAttribute("flag", flag);
			return "Menu";
		}
		flag = 0;
		model.addAttribute("flag", flag);
		return "Menu";
	}


	@RequestMapping(path = "/costruisci")
	public String costruisci(@WebParam String sigla, Model model, HttpServletRequest request) throws IOException {
		String username = (String) request.getSession().getAttribute("username");
		Errori e1 = new Errori(sigla);
		try {
			TrenoBuilder trenoTN = new TNBuilder();
			Treno treno = trenoTN.costruisci(sigla);
			System.out.println(treno);

			TrenoDao trenoDAO = TrenoDaoImpl.getInstance();
			UtenteDao utenteDAO = UtenteDaoImpl.getInstance();

			trenoDAO.add(treno, utenteDAO.findByUsername(username));

			List<String> trenoSigla = new LinkedList<String>();
			String locomotiva = "<img class='main-treno' src='./img/locomotivaV.png' width='150'>";
			String passeggeri = "<img class='main-treno' src='./img/passeggeriV.png' width='150'>";
			String ristorante = "<img class='main-treno' src='./img/ristoranteV.png' width='150' >";
			String cargo = "<img class='main-treno' src='./img/cargoV.png' width='150'>";
			for (int i = 0; i < sigla.length(); i++) {
				switch (sigla.charAt(i)) {
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
				model.addAttribute("trenoSigla", prova(trenoSigla));
				model.addAttribute("sigla", sigla);
			}
		} catch (Exception e) {
			model.addAttribute("errore", e1.getMessage(sigla));
			model.addAttribute("siglaSuggerita", e1.siglaSuggerita(sigla));
		}

		return "CreazioneTreno";

	}

	@RequestMapping(path = "/treni")
	public String treni(Model model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		request.getSession().setAttribute("username",username);
		TrenoDao trenoDAO = TrenoDaoImpl.getInstance();

		List<TrenoDTO> listaTreniUtente = new ArrayList<>();
		List<String> trenoSigla = new LinkedList<String>();

		String locomotiva = "<img class='main-treno' src='./img/locomotivaV.png' width='150'>";
		String passeggeri = "<img class='main-treno' src='./img/passeggeriV.png' width='150'>";
		String ristorante = "<img class='main-treno' src='./img/ristoranteV.png' width='150' >";
		String cargo = "<img class='main-treno' src='./img/cargoV.png' width='150'>";

		for (TrenoDTO t : trenoDAO.listaTreni()) {
			if (t.getUtente().getUsername().equals(username)) {
				System.out.println(t);
				for (int i = 0; i < t.getSigla().length(); i++) {
					List<String> sigla = new LinkedList<String>();
					switch (t.getSigla().charAt(i)) {
					case 'H':
						trenoSigla.add("<p id='lt'>" + t.getSigla() + "</p>");
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
				trenoSigla.add("<form action='elimina'><input type='submit' name='id' value='"+ t.getId() +"'></input></form>");
				trenoSigla.add("<br>");
				model.addAttribute("id", t.getId());
			}
		}

		model.addAttribute("trenoSigla", prova(trenoSigla));
		model.addAttribute("listaTreni", listaTreniUtente);

		return "treni";
	}
	
	@RequestMapping(path = "/elimina")
	public String elimina(int id) {
		TrenoDao trenoDAO = TrenoDaoImpl.getInstance();
		trenoDAO.deleteTreno(id);
		return "elimina";
	}

	public static String prova(List list) {
		String finale = "";
		for (int i = 0; i < list.size(); i++) {
			finale = finale + "   " + list.get(i) + "   ";
		}
		return finale;

	}

}
