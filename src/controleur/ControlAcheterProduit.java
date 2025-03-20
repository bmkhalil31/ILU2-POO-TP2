package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean isHabitant(String nomAchteur) {
		
		return controlVerifierIdentite.verifierIdentite(nomAchteur);
		
	}
	
	public boolean isVendu(String nomProduit) {
		
		return village.rechercherVendeursProduit(nomProduit)!=null;
		
	}
	
	public String[] donnerVendeurProduit(String nomProduit) {
		Gaulois[] vendeursProduit= village.rechercherVendeursProduit(nomProduit);
		String[] listeVendeurProduit=new String[vendeursProduit.length];
		for (int i = 0; i < vendeursProduit.length; i++) {
			listeVendeurProduit[i]=vendeursProduit[i].getNom();
			
		}
		return listeVendeurProduit;
		
	}
	
	public int quantiteDiponible(String nomVendeur) {
		
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite();
		
		
	}
	
	public void acheterProduit(String nomVendeur,int quantite) {
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
		
	}
   

}
