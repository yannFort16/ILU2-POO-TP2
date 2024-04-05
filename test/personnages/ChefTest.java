package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	void chef () {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testParler() {
		abraracourcix.parler("texte");
	}

	@Test
	void testPrendreParole() {
		String expected = "Le chef Abraracourcix du village le village des irréductibles : ";
		assertEquals(expected, abraracourcix.prendreParole());
	}

}
