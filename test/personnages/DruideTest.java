package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DruideTest {

	@Test
	void testBooster() {
		Gaulois g = new Gaulois("NomBasic", 5);
		Druide d = new Druide("Druid", 2, 5, 7);
		d.preparerPotion();
		d.booster(g);
		
		assertTrue( g.getEffectPotion() >=5 && g.getEffectPotion() <=7);
	}
	
	@Test
	void testBoosterObelix() {
		Gaulois ob = new Gaulois("Obélix", 5);
		Druide d = new Druide("Druid", 2, 5, 7);
		d.preparerPotion();
		d.booster(ob);
		
		assertTrue( ob.getEffectPotion() ==1);
	}
	
	@Test
	void testBoosterSupSeven() {
		Gaulois g = new Gaulois("NomBasic", 5);
		Druide d = new Druide("Druid", 2, 8, 10);
		d.preparerPotion();
		d.booster(g);
		
		assertTrue( g.getEffectPotion() >=8 && g.getEffectPotion() <=10);
	}
}
