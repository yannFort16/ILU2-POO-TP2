package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TOD à completer
		if(!controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Je suis désolée "+ nomAcheteur+" mais il "
					+ "faut être un habitant de notre "
					+ "village pour commercer ici");
		} else {	
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			String[] vendeurs = controlAcheterProduit.isProduit(produit);
			if (vendeurs.length==0) {
				System.out.println("“Désolé, personne "
						+ "ne vend ce produit au marché.");
			} else {
				System.out.println(afficherVendeur(vendeurs, produit));
				int choix = scan.nextInt() -1;
				String nomVendeur = vendeurs[choix];
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal "
						+ "du vendeur " + nomVendeur +".\n" +
						"Bonjour, " + nomAcheteur +".\n"+
						"Combien de " + produit + " voulez-vous acheter ?");
				int quantite = scan.nextInt();
				int recu = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
				if (recu == 0) {
					System.out.println(nomAcheteur +" veut acheter " + quantite + " " +
							produit + ", malheureusement il n’y en a plus !");
				} 
				if(recu < quantite) {
					System.out.println(nomAcheteur +" veut acheter " + quantite + " " +
							produit + ", malheureusement " + nomVendeur + 
							" n'en a plus que " + recu + ". " + nomAcheteur +
							" achète tout le stock de " + nomVendeur + ".");
				} 
				if(recu == quantite) {
					System.out.println(nomAcheteur + " achète " + recu + " à " +
							nomVendeur);
				}
			}
		}
	}
	
	public String afficherVendeur(String[] vendeurs, String produit) {
		StringBuilder question = new StringBuilder();
		question.append("Chez quel commerçant voulez-vous "
				+ "acheter des " + produit +"?\n");
		for(int i=0; i<vendeurs.length; i++) {
			question.append((i+1) + " - " + vendeurs[i] + "\n");
		}
		return question.toString();
	}
}
