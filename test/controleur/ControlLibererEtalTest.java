package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void setUp()  {
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		Gaulois gaulois =new Gaulois("gaulois", 2);
		assertFalse(controlLibererEtal.isVendeur(gaulois.getNom()));
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "produit", 1);
		assertTrue(controlLibererEtal.isVendeur(gaulois.getNom()));
	}

	@Test
	void testLibererEtal() {
		Gaulois gaulois =new Gaulois("gaulois", 2);
		village.ajouterHabitant(gaulois);
		assertNull(controlLibererEtal.libererEtal(gaulois.getNom()));
		village.installerVendeur(gaulois, "produit", 1);
		assertNotNull(controlLibererEtal.libererEtal(gaulois.getNom()));
		assertNull(controlLibererEtal.libererEtal(gaulois.getNom()));
	}

}
