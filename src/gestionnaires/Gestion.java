package gestionnaires;

import java.util.ArrayList;

import enumerer.genre_e;
import enumerer.niveau_e;
import enumerer.type_e;
import base.Media;
import base.MediaInexistantException;
import base.Note;
import base.Utilisateur;

public class Gestion {
	
private ArrayList<Media> medium;
	
	public Gestion( ArrayList<Media> medium ){
		this.medium = medium;
	}
	
	public Media gestionEmpruntMedia(int idMd, Utilisateur user) throws MediaInexistantException{
		
		for (Media md : medium)
			if (md.getMon_id() == idMd){
				user.ajoutEmprunt(md);
				return md;
			}
		
		throw new MediaInexistantException();
	}
	
	public Media gestionConsulterMedia(int idMd) throws MediaInexistantException{
		
		for (Media md : medium)
			if (md.getMon_id() == idMd){
				return md;
			}
		
		throw new MediaInexistantException();
	}
	
	public Media gestionEvaluerMedia(int idMd, int note, Utilisateur user) throws MediaInexistantException{
		
		for (Media md : medium)
			if (md.getMon_id() == idMd){
				Note n = new Note();
				md.getNotes().add(n.nouvelleNote(note, user));
				return md;
			}
		
		throw new MediaInexistantException();
	}
	
	public ArrayList<Media> gestionRechercheMedium(String nom, genre_e genre, niveau_e niv, type_e type) {
		
		if (nom == null && genre == null && niv == null && type == null)
			return medium;
		
		// 1 critere de recherche
		if (nom == null && genre == null && niv == null && type != null)
			return rechercheType(type);
		
		if (nom == null && genre == null && niv != null && type == null)
			return rechercheNiv(niv);
		
		if (nom == null && genre != null && niv == null && type == null)
			return rechercheGenre(genre);
		
		if (nom != null && genre == null && niv == null && type == null)
			return rechercheNom(nom);
		
		// 2 criteres de recherche
		if (nom == null && genre == null && niv != null && type != null)
			return rechercheNivType(niv, type);
		
		if (nom == null && genre != null && niv == null && type != null)
			return rechercheGenreType(genre, type);
		
		if (nom != null && genre == null && niv == null && type != null)
			return rechercheNomType(nom, type);
		
		if (nom == null && genre != null && niv != null && type == null)
			return rechercheGenreNiv(genre, niv);
		
		if (nom != null && genre == null && niv != null && type == null)
			return rechercheNomNiv(nom, niv);
		
		if (nom != null && genre != null && niv == null && type == null)
			return rechercheNomGenre(nom, genre);
		
		// 3 criteres de recherche
		if (nom == null && genre != null && niv != null && type != null)
			return rechercheGenreNivType(genre, niv, type);
		
		if (nom != null && genre == null && niv != null && type != null)
			return rechercheNomNivType(nom, niv, type);
		
		if (nom != null && genre != null && niv == null && type != null)
			return rechercheNomGenreType(nom, genre, type);
		
		if (nom != null && genre != null && niv != null && type == null)
			return rechercheNomGenreNiv(nom, genre, niv);
		
		// 4 criteres de recherche
		if (nom != null && genre != null && niv != null && type != null)
			return rechercheAll(nom, genre, niv, type);
		
		return null;
	}
		
	private ArrayList<Media> rechercheType(type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNiv(niveau_e niv) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNiveau() == niv)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheGenre(genre_e genre) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getGenre() == genre)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNom(String nom) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) )
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNivType(niveau_e niv, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNiveau() == niv && md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheGenreType(genre_e genre, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getGenre() == genre && md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNomType(String nom, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheGenreNiv(genre_e genre, niveau_e niv) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getGenre() == genre && md.getNiveau() == niv)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNomNiv(String nom, niveau_e niv) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getNiveau() == niv)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNomGenre(String nom, genre_e genre) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getGenre() == genre)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheGenreNivType(genre_e genre, niveau_e niv, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getGenre() == genre && md.getNiveau() == niv && md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNomNivType(String nom, niveau_e niv, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getNiveau() == niv && md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNomGenreType(String nom, genre_e genre, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getGenre() == genre && md.getType() == type)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheNomGenreNiv(String nom, genre_e genre, niveau_e niv) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getGenre() == genre && md.getNiveau() == niv)
				res.add(md);
		
		return res;
	}

	private ArrayList<Media> rechercheAll(String nom, genre_e genre, niveau_e niv, type_e type) {
		ArrayList<Media> res = new ArrayList<Media>();
		
		for (Media md : medium)
			if (md.getNom().equals(nom) && md.getGenre() == genre && md.getNiveau() == niv && md.getType() == type)
				res.add(md);
		
		return res;
	}

	public float gestionMoyenne(int idMd) throws MediaInexistantException{
		
		for (Media md : medium){
			if (md.getMon_id() == idMd){
				int nbNotes = md.getNotes().size();
				int somme = 0;
				
				for ( Note n : md.getNotes() ){
					somme += n.getValeur();
				}
				
				return ( (float)somme)/nbNotes;
			}
		}
		
		throw new MediaInexistantException();
	}


	public void gestionNouveauMedia(String nom, genre_e genre, niveau_e niveau, type_e type) {
		Media med = new Media(nom, genre, niveau, type);
		medium.add(med);
	}

	public void gestionSupprimerMedia(int idMd) {
		ArrayList<Media> nvMedium = new ArrayList<Media>();
		
		for (Media md : medium){
			if (md.getMon_id() != idMd){
				nvMedium.add(md);
			}
		}
		
		medium = new ArrayList<Media>(nvMedium);
	}

}
