package controleur;

import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TOD a completer, attention le retour ne dit pas etre false :-)
		return null != village.trouverHabitant(nomVendeur);
		//return false;
	}
}
