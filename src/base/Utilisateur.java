package base;

import java.util.ArrayList;

public class Utilisateur {
	
	private ArrayList<Media> Mes_emprunts;
	
	public void ajoutEmprunt(Media md) {
		Mes_emprunts.add(md);
	}
}
