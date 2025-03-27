package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNomsVillageois(){
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 1);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0], abraracourcix.getNom());
		Gaulois gaulois=new Gaulois("gaulois",5);
		village.ajouterHabitant( gaulois);
		assertEquals(controlAfficherVillage.donnerNomsVillageois().length, 2);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0], abraracourcix.getNom());
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1], gaulois.getNom());
		
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);

	}
	
	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");

	}
	
}
