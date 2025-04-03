package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void setUp(){
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur);
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois gaulois =new Gaulois("gaulois", 2);
		village.ajouterHabitant(gaulois);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur(gaulois.getNom()));
		village.installerVendeur(gaulois, "produit", 2);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur(gaulois.getNom()));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur(abraracourcix.getNom()));

		}
	

}
