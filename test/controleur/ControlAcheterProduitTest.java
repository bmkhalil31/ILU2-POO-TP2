package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAcheterProduit = new ControlAcheterProduit(null, null, village);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
