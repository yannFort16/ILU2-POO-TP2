package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois vendeur;
	
	@BeforeEach
	void ControlAfficherMarcherTest (){
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
	}

	@Test
	void testAfficherMarcher() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] res = controlAfficherMarche.donnerInfosMarche();
		String[] expected = {"Bonemine", "10", "fleurs"};
		assertNotNull(res);
		for(int i=0; i<res.length;i++) {
			assertEquals(expected[i], res[i]);
		}
	}

}
