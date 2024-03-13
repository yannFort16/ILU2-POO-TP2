package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		//TOD a completer
		Etal etal = null;
		Gaulois g = village.trouverHabitant(nomVendeur);
		if(g != null) {
			etal=village.rechercherEtal(g);
		}
		return etal;
	}
}
