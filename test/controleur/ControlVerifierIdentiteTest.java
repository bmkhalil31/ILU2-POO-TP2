package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotEquals(controlVerifierIdentite, null);
	}
	
	@Test 
	void testVerifierIdentite() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("non verifie"));
		Gaulois gaulois=new Gaulois("gaulois",5);
		village.ajouterHabitant( gaulois);
		assertTrue(controlVerifierIdentite.verifierIdentite("gaulois"));
		assertFalse(controlVerifierIdentite.verifierIdentite("non gaulois"));

	}

}
