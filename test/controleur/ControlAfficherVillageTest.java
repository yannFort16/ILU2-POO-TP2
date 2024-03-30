package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois vendeur;
	private Druide druide;
	
	@BeforeEach
	void contolAfficherVillage() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
		druide = new Druide("Panoramix", 2, 3, 8);
		village.ajouterHabitant(druide);
		
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] res = controlAfficherVillage.donnerNomsVillageois();
		String[] expected = {"Abraracourcix", "Bonemine", "le druide Panoramix"};
		for (int i=0; i<res.length;i++) {
			assertEquals(expected[i], res[i]);
		}
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(village.getNom(), controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}
}
