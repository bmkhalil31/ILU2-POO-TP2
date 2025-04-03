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
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite= new ControlVerifierIdentite(village);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testResteEtals() {
		for (int i = 0; i < 5; i++) {
			Gaulois gaulois=new Gaulois("gaulois"+i, 5);
			assertTrue(controlPrendreEtal.resteEtals());
			village.installerVendeur(gaulois, "produit", 1);	
			
		}
		
		assertFalse(controlPrendreEtal.resteEtals());
	}
	@Test 
	void testVerifierIdentite() {
		assertTrue(controlPrendreEtal.verifierIdentite(abraracourcix.getNom()));
		Gaulois gaulois=new Gaulois("gaulois", 5);
		assertFalse(controlPrendreEtal.verifierIdentite(gaulois.getNom()));
		
	}
	
	@Test
	void testPrendreEtal() {
		for (int i = 0; i < 5; i++) {
			Gaulois gaulois=new Gaulois("gaulois"+i, 5);
			assertEquals(controlPrendreEtal.prendreEtal(gaulois.getNom(), "produit", 1), i);
			
				
			
		}
		Gaulois gaulois=new Gaulois("gaulois", 5);
		assertEquals(controlPrendreEtal.prendreEtal(gaulois.getNom(), "produit", 1), -1);

		
	}

}
