package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public Boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] isProduit (String produit) {
		Gaulois[] g = village.rechercherVendeursProduit(produit);
		String[] nomVendeur = new String[g.length];
		for(int i=0; i<g.length;i++) {
			nomVendeur[i]=g[i].getNom();
		}
		return nomVendeur;
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int nbProd = etal.acheterProduit(quantite);
		return nbProd;
	}
	
	
	//TOD a completer
}
