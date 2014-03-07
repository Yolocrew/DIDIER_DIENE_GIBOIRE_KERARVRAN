package base;

public class Note {
	private int valeur;			//La valeur est comprise entre 0 et 5 inclus
	private Utilisateur user;
	
	public Note(){
		valeur = -1;
		user = null;
	}
	
	private Note(int val, Utilisateur util){
		valeur = val;
		user = util;
	}
	
	public Note nouvelleNote(int val, Utilisateur util){
		if (val < 0 || val > 5)
			return null;
		
		return new Note(val, util);
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Utilisateur getUser() {
		return user;
	}
}
