package facades;

import java.util.ArrayList;

import enumerer.genre_e;
import enumerer.niveau_e;
import enumerer.type_e;
import gestionnaires.Gestion;
import base.Media;
import base.MediaInexistantException;

public class FacadeAd {
	private Gestion ge;
	
	public FacadeAd (ArrayList<Media> medium){
		ge = new Gestion(medium);
	}
	
	public void deposer(String nom, genre_e genre, niveau_e niveau, type_e type) {
		ge.gestionNouveauMedia(nom, genre, niveau, type);
	}
	
	public void supprimer(int idMed) {
		ge.gestionSupprimerMedia(idMed);
	}
	
	/*public void MAJ() {
		
	}*/
	
	public ArrayList<Media> rechercher(String nom, genre_e genre, niveau_e niv, type_e type) {
		return ge.gestionRechercheMedium(nom, genre, niv, type);
	}
	
	/*public void consulteHisto() {
		
	}*/
	
	public float consulteEtat(int idMed) throws MediaInexistantException {
		return ge.gestionMoyenne(idMed);
	}
}
