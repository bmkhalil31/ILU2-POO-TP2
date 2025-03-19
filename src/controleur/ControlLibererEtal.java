package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	
	public boolean isVendeur(String nomVendeur) {
		
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
		
	}
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		
		String[] donneesEtal = new String[5];
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		donneesEtal[0]=((Boolean)etal.isEtalOccupe()).toString();
		donneesEtal[1]=etal.getVendeur().getNom();
		donneesEtal[2]=etal.getProduit();
		donneesEtal[3]=((Integer)etal.getQuantiteDebutMarche()).toString();
		donneesEtal[4]=((Integer)etal.getQuantite()).toString();

		
		
		return donneesEtal;
	}

}
