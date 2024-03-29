package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois vendeur;
	
	@BeforeEach
	public void controlAcheterProduit () {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
	}
	
	@Test
	void testIsHabitant() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.isHabitant("Bonemine"));
		assertFalse(controlAcheterProduit.isHabitant("Asterix"));
		
	}
	
	@Test
	void testIsProduit() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		String[] lstVendeur = controlAcheterProduit.isProduit("fleurs");
		assertEquals(1, lstVendeur.length);
		assertEquals(vendeur.getNom(), lstVendeur[0]);
		//assertEquals(0, controlAcheterProduit.isProduit("pain"));
	}
	
	@Test
	void testAcheterProduit() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(2, controlAcheterProduit.acheterProduit(vendeur.getNom(), 2));
		assertEquals(8, controlAcheterProduit.acheterProduit(vendeur.getNom(), 9));
		assertEquals(0, controlAcheterProduit.acheterProduit(vendeur.getNom(), 2));
		
	}

}
