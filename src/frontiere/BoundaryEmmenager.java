package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TOD a completer
		System.out.println("Bienvenue villageois " + nomVisiteur);
		int force = -1;
		int pForceMax = -1;
		int pForceMin = -1;
		do {
			if (force<0) {
				force = Clavier.entrerEntier("Quelle est votre force?");
			}
			if (pForceMax<0) {
				pForceMax = Clavier.entrerEntier(
						"Quelle est la force maximal de votre potion?");
			}
			if (pForceMin<0 && pForceMin<=pForceMax) {
				pForceMin = Clavier.entrerEntier(
						"Quelle est la force minimal de votre potion?");
			}
		} while (force < 0 && pForceMax < 0 && pForceMin  < 0 && pForceMin<=pForceMax);
		controlEmmenager.ajouterDruide(nomVisiteur, force, pForceMin, pForceMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		//TOD a completer
		System.out.println("Bienvenue villageois " + nomVisiteur);
		int force = -1;
		do {
			force = Clavier.entrerEntier("Quelle est votre force?");
		} while (force < 0);
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
