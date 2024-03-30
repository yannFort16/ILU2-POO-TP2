package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois vendeur;
	
	@BeforeEach
	public void controlLibererEtal () {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		vendeur = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
	}

	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new
				ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new 
				ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.isVendeur(vendeur.getNom()));
		assertFalse(controlLibererEtal.isVendeur(abraracourcix.getNom()));
	}	
	
	@Test
	void testLibererEtalUtiliser() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new
				ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new 
				ControlLibererEtal(controlTrouverEtalVendeur);
		String[] expected = {"true", vendeur.getNom(), "fleurs", "10", "0"} ;
		String[] result = controlLibererEtal.libererEtal(vendeur.getNom()); 
		/*System.out.println(result[0] +"\n" +
				result[1] +"\n" +
				result[2] +"\n" +
				result[3] +"\n" +
				result[4] +"\n");
		System.out.println(expected.equals(result));*/
		for (int i=0; i<result.length;i++) {
			assertTrue(expected[i].equals(result[i]));
		}
		//assertTrue(expected.equals(result));
		//assertEquals(expected, result);
	}
	
	@Test
	void testLibererEtalVide() {
		ControlTrouverEtalVendeur contoControlTrouverEtalVendeur = new
				ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new 
				ControlLibererEtal(contoControlTrouverEtalVendeur);
		village.partirVendeur(vendeur);
		assertEquals("false", controlLibererEtal.libererEtal(vendeur.getNom())[0]);
		assertNull(controlLibererEtal.libererEtal(abraracourcix.getNom()));
	}
}
