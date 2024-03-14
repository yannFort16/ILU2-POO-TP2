package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infos = controlAfficherMarche.donnerInfosMarche();
		StringBuilder infosMarche = new StringBuilder();
		if (infos.length == 0) {
			infosMarche.append("Le marché est vide revenez plus tard.\n");
		} else {
			infosMarche.append(nomAcheteur + ", vous trouverez au marché:\n");
			for (int i=0; i<infos.length/3; i++) {
				infosMarche.append("- " + infos[i*3] + " qui vend " +
						infos[i*3+1] + " " + infos[i*3+2]);
			}
		}
		System.out.println(infosMarche.toString());
	}
}
