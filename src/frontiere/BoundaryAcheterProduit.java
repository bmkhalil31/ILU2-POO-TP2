package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

		if (!controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println(
					"Désolé mais " + nomAcheteur + " il faut etre un habitabt de notre village pour commercer ici.");
		} else {

			String nomProduit = Clavier.entrerChaine("Quel Produit voulez-vous acheter");

			if (!controlAcheterProduit.isVendu(nomProduit)) {
				System.out.println("Désolé, personne ne vend ce produit au marché");

			} else {

				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs?");
				String[] listeVendeur = controlAcheterProduit.donnerVendeurProduit(nomProduit);
				for (int i = 0; i < listeVendeur.length; i++) {
					System.out.println((i + 1) + "- " + listeVendeur[i]);
				}
				int numVendeur = Clavier.entrerEntier("");
				String nomVendeur = listeVendeur[numVendeur - 1];
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
				System.out.println("Bonjour " + nomAcheteur);
				int quantiteVoulu = Clavier.entrerEntier("Combien de " + nomProduit + " voulez-vous acheter?");
				int quanteteDisponible = controlAcheterProduit.quantiteDiponible(nomVendeur);
				if (quanteteDisponible == 0) {
					System.out.println(nomAcheteur + "veut acheter" + quantiteVoulu + " " + nomProduit
							+ ", malheureusement il n'y en a plus !");

				} else if (quanteteDisponible < quantiteVoulu) {
					System.out.println(nomAcheteur + "veut acheter" + quantiteVoulu + " " + nomProduit
							+ ", malheureusement " + nomVendeur + " n'en a plus que " + quanteteDisponible + ". "
							+ nomAcheteur + " achète tout le stock de " + nomVendeur);
					controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulu);
				} else {
					System.out
							.println(nomAcheteur + " achete " + quantiteVoulu + " " + nomProduit + " à " + nomVendeur);
					controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulu);
				}

			}
			System.out.println("Quel produit voulez-vous acheter?");

		}

	}
}
