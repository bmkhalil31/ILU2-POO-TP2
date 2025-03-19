package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolé" + nomVendeur
					+ " mais il faut etre un habitant de notre ce village pour commercer ici.");
		} else {
			System.out.println("Bonjour" + nomVendeur + " je vais regarder si je peux vous trouver un étal.");
            boolean etalDiponible=controlPrendreEtal.resteEtals();
            if (!etalDiponible) {
            	System.out.println("Désolé"+nomVendeur+" je n'ai plus d'étal qui ne soit pas déja occupé");
				
			} else {
				installerVendeur(nomVendeur);
				

			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		
		System.out.println("C'est parfait, il me reste un étal pour vous!");
		System.out.println("il me faudrait quelques renseignements:");
		String produit=Clavier.entrerChaine("Quel produit souhaitez vous vendre?");
		int nbProduit=Clavier.entrerEntier("Combien souhaitez vous en vendre?");
		int numEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numEtal!=-1) {
			System.out.println("Le vendeur"+nomVendeur+" s'est installé à l'étal n°"+numEtal+1);
		}
	}
}
