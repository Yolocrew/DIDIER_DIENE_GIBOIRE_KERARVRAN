package base;

import java.util.ArrayList;

import enumerer.genre_e;
import enumerer.niveau_e;
import enumerer.type_e;

public class Media {
	
	private static int id_courrant = 0;
	private int mon_id;
	private String nom;
	private genre_e genre;
	private niveau_e niveau;
	private type_e type;
	private ArrayList<Note> notes;
	
	public Media (String n, genre_e g, niveau_e niv, type_e t){
		nom = n;
		genre = g;
		niveau = niv;
		type = t;
		mon_id = id_courrant++;
	}

	public int getMon_id() {
		return mon_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public genre_e getGenre() {
		return genre;
	}

	public void setGenre(genre_e genre) {
		this.genre = genre;
	}

	public niveau_e getNiveau() {
		return niveau;
	}

	public void setNiveau(niveau_e niveau) {
		this.niveau = niveau;
	}
	
	public type_e getType() {
		return type;
	}

	public void setType(type_e type) {
		this.type = type;
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}

}
