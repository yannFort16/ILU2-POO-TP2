package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {

	/*@Test
	void testPersonnage() {
		//Personnage sisyphus = new Personnage("Sisyphus", -6);
		Personnage sisyphus = null;
		try {
			sisyphus = new Personnage("Sisyphus", -6);
		}catch (Exception e) {
			System.out.println("Force<0 inderdite");
		}
		assertNull(sisyphus);
	}*/
	
	@Test
	void testGetForce() {
		Personnage sisyphus = new Personnage("Sisyphus", 20);
		assertEquals(20, sisyphus.getForce());
	}
	
	@Test
	void testToString() {
		Personnage sisyphus = new Personnage("Sisyphus", 20);
		assertEquals("[nom=Sisyphus, force=20]", sisyphus.toString());
	}
	
	@Test
	void testPrendreParole() {
		Personnage sisyphus = new Personnage("Sisyphus", 20);
		assertEquals("Sisyphus : ", sisyphus.prendreParole());
	}
}
