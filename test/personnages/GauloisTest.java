package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {

	@Test
	void testPrendreParole() {
		Gaulois testix = new Gaulois("Testix" , 10);
		assertEquals("Le gaulois Testix : ", testix.prendreParole());
	}
	
	@Test
	void testToString() {
		Gaulois testix = new Gaulois("Testix" , 10);
		
		String expected = "Gaulois [nom=Testix, force=10, effetPotion=1]";
		
		assertEquals(expected, testix.toString());
	}
	
	@Test
	void testBoirePotion() {
		Gaulois testix = new Gaulois("Testix" , 10);
		
		testix.boirePotion(5);
		
		String expected = "Gaulois [nom=Testix, force=10, effetPotion=5]";
		assertEquals(expected, testix.toString());
	}

}
