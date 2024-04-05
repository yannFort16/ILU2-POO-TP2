package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois vendeur;
	
	@BeforeEach
	public void controlPrendreEtal () {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
	}

	@Test
	void testResteEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
				controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testResteEtalFalse() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
				controlVerifierIdentite, village);
		village.installerVendeur(vendeur, "truc1", 2);
		village.installerVendeur(vendeur, "truc2", 2);
		village.installerVendeur(vendeur, "truc3", 2);
		village.installerVendeur(vendeur, "truc4", 2);
		village.installerVendeur(vendeur, "truc5", 2);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
				controlVerifierIdentite, village);
		assertEquals(0, controlPrendreEtal.prendreEtal(
				vendeur.getNom(), "fleurs", 10));
	}
	
	@Test
	void testVerifierIdentier() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
				controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite(vendeur.getNom()));
	}

}
