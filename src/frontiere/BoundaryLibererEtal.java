package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TOD a completer
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Vous n'êtes pas inscrit sur notre marché aujourd'hui");
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = "true".equals(donneesEtal[0]);
			if(etalOccupe) {
				System.out.println("Vous avez vendu " + donneesEtal[4] +
						" sur " + donneesEtal[3] + " " + donneesEtal[2] +".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.");
			}
		} 	
	}

}
