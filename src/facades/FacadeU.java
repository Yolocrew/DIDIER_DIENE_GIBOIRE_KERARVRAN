package facades;

import java.util.ArrayList;

import enumerer.genre_e;
import enumerer.niveau_e;
import enumerer.type_e;
import gestionnaires.Gestion;
import base.Media;
import base.MediaInexistantException;
import base.Utilisateur;

public class FacadeU {
	
	private Utilisateur user;
	private Gestion ge;
	
	public FacadeU (Utilisateur util, ArrayList<Media> medium){
		ge = new Gestion(medium);
		user = util;
	}
	
	public boolean emprunter(int id) throws MediaInexistantException {
	
		if ( ge.gestionEmpruntMedia(id, user) == null)
			return false;
		else
			return true;
	
	}
	
	public Media consulter(int id) throws MediaInexistantException {
		return ge.gestionConsulterMedia(id);
	}
	
	public ArrayList<Media> rechercher(String nom, genre_e genre, niveau_e niv, type_e type) {
		return ge.gestionRechercheMedium(nom, genre, niv, type);
	}
	
	public void evaluer(int id, int note) throws MediaInexistantException {
		ge.gestionEvaluerMedia(id, note, user);
	}

}
