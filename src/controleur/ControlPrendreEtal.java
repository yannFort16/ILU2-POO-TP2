package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TOD a completer, attention le retour ne dit pas etre false :-)
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		//TOD a completer
		int numeroEtal = -1;
		Gaulois g = village.trouverHabitant(nomVendeur);
		numeroEtal= village.installerVendeur(g, produit, nbProduit);
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TOD a completer, attention le retour ne dit pas etre false :-)
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
		//return false;
	}
}
