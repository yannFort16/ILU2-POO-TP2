package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TOD a completer
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée "+ nomVendeur +" mais il faut être un "
					+"habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour "+ nomVendeur +", je vais regarder "
					+ "si je peux vous trouver un étal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé, " + nomVendeur +
						" je n'ai plus d'étal qui ne soit pas déjà occupé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}	
	}

	private void installerVendeur(String nomVendeur) {
		//TOD a completer
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un étal pour vous!\n");
		question.append("Il me faudrait quelque renseignement.\n"+
						"Quel produit souhaitez vous vendre ?");
		System.out.println(question);
		String produit = scan.next();
		int quantite = Clavier.entrerEntier("Combien souhaitez vous vendre ?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		if (numEtal != -1) {
			System.out.println("le vendeur " + nomVendeur +
					" s'est installé à l'étal n°"+ numEtal);
		}		
	}
}
