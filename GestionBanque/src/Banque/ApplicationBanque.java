package Banque;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationBanque {

	/**
	 * @param args
	 */

	ArrayList<CompteClient> listCompteClient = new ArrayList<CompteClient>();
	ArrayList<TransactionBancaire> listtrans = new ArrayList<TransactionBancaire>();

	public ArrayList<CompteClient> getListCompteClient() {
		return listCompteClient;
	}

	public void setListCompteClient(ArrayList<CompteClient> listCompteClient) {
		this.listCompteClient = listCompteClient;
	}

	public ArrayList<TransactionBancaire> getListtrans() {
		return listtrans;
	}

	public void setListtrans(ArrayList<TransactionBancaire> listtrans) {
		this.listtrans = listtrans;
	}

	public CompteClient creerCompteClient(int num, int numIDCompte, String nomTitulaireCompte, float taux,
			float soldeCompte) {
		CompteClient compte = null;
		if (num > 0 && numIDCompte > 0 && (taux < 100 && taux > 0)) {
			compte = new CompteClient();
			compte.setNumCompte(num);
			compte.setNumIDCompte(numIDCompte);
			compte.setNomTitulaireCompte(nomTitulaireCompte);
			compte.setSoldeCompte(soldeCompte);
			compte.setTaux(taux);
			listCompteClient.add(compte);
		}
		return compte;
	}

	public void creerCompteClient(CompteClient compte) {
		if (compte.getNumCompte() > 0 && compte.getNumIDCompte() > 0 && (compte.taux < 100 && compte.taux > 0)) {
			listCompteClient.add(compte);
		}
	}

	public int nombreDeClient() {
		return listCompteClient.size();
	}

	public CompteClient getCompteAvecNum(int num) {
		for (CompteClient c : listCompteClient) {
			if (c.getNumCompte() == num) {
				return c;
			}
		}
		System.out.println("Le compte n'a pas été trouvé!");
		return null;
	}

	public void lancerApp() {
		// Affichage du Menu Principale de notre application

		Scanner saisir = new Scanner(System.in);
		char menuchoisi = '0';
		while (menuchoisi == '0') {
			System.out.println("MENU PRINCIPAL" + "---------------------------------");

			System.out.println("1:CREATION DE COMPTE\n" + "2:TYPE DE TRANSACTION\n"
					+ "3:CONSULTER LE SOLDE D'UN COMPTE\n" + "4:CALCUL DES INTERET ET MISE A JOUR DES COMPTES\n"
					+ "5:DONNER UN RAPPORT(numero id,avoir un compte ou pas)\n"
					+ "6:RECHERCHER UN COMPTE A PARTIR DU NUMERO D'IDENTIFICATION\n");

			System.out.println("merci de faire votre choix!!!");
			menuchoisi = saisir.nextLine().charAt(0);
			// traitement en fonction du choix du menu

			switch (menuchoisi) {
			case '1':
				// Affichage du compte

				System.out.println("merci de bien saisir le numero pour votre compte");
				int numCompte = Integer.parseInt(saisir.nextLine());
				System.out.println("veuillez choisir votre numero d'identifiant pour votre compte");
				int numIdCompte = Integer.parseInt(saisir.nextLine());
				System.out.println("veuillez mettre votre nom d'identifiant");
				String nomTitulaireCompte = saisir.nextLine();
				System.out.println("le solde de votre est:");
				float soldeCompte = saisir.nextFloat();
				System.out.println("le taux de votre compte est de %:");
				float taux = saisir.nextFloat();

				saisir.nextLine();

				CompteClient compte = new CompteClient();
				compte.setNumCompte(numCompte);
				compte.setNumIDCompte(numIdCompte);
				compte.setNomTitulaireCompte(nomTitulaireCompte);
				compte.setSoldeCompte(soldeCompte);
				compte.setTaux(taux);
				listCompteClient.add(compte);

				System.out.println("Operation reussie \n");

				break;

			case '2':
				// transaction a effectuer
				System.out.println("selectionnez le type de la transaction:\n" + "A:depot\n" + "B:retrait");
				menuchoisi = saisir.nextLine().charAt(0);
				// TransactionBancaire trans = null;
				TypeTransaction type = TypeTransaction.depot;
				// traitement du typede transaction
				if (menuchoisi == 'B') {
					type = TypeTransaction.retrait;
				}
				System.out.println("le numero de la transaction");
				int numTransaction = Integer.parseInt(saisir.nextLine());
				System.out.println("saisissez le numero de compte pour la transaction");
				int numCompt = Integer.parseInt(saisir.nextLine());
				System.out.println("Quel est le montant a deposer");
				float montant = Float.parseFloat(saisir.nextLine());

				// enregistrement de la transaction.
				TransactionBancaire trans = new TransactionBancaire();
				trans.setNumCompte(numCompt);
				trans.setNumTransaction(numTransaction);
				trans.setDateTrasaction();
				trans.setMontant(montant);
				trans.setTypeTransaction(type);
				listtrans.add(trans);

				// mise a jour du solde

				for (CompteClient cpt : listCompteClient) {
					if (cpt.getNumCompte() == numCompt) {
						switch (menuchoisi) {
						case 'A':
							cpt.setSoldeCompte(cpt.getSoldeCompte() + montant);
							break;
						case 'B':
							cpt.setSoldeCompte(cpt.getSoldeCompte() - montant);
							break;
						}

					}
				}

				break;
			// consultation du solde de compte
			case '3':
				System.out.println("saisir le numero de compte");
				int numComptes = Integer.parseInt(saisir.nextLine());
				for (CompteClient cpt : listCompteClient) {
					if (cpt.getNumCompte() == numComptes) {
						System.out.println("le solde du compte est" + cpt.getSoldeCompte());
					}

				}

				break;
			// calcul des interet et mise à jour des comptes.

			case '4':
				for (CompteClient cpt : listCompteClient) {
					float interet = cpt.getSoldeCompte() * cpt.getTaux() / 100;
					cpt.setSoldeCompte(cpt.getSoldeCompte() + interet);

				}
				break;
			// rapport qui inclut le numero de compte,le solde ,la date, et les
			// transactions.

			case '5':

				for (CompteClient cpt : listCompteClient) {
					System.out.println("numero de compte:" + cpt.getNumCompte() + "solde :" + cpt.getSoldeCompte()
							+ " nom :" + cpt.getNomTitulaireCompte());
					for (TransactionBancaire transa : listtrans) {
						if (transa.getNumCompte() == cpt.getNumCompte()) {
							System.out.println("type: " + transa.getTypeTransaction() + "  numero transaction :"
									+ transa.getNumTransaction() + " date :" + transa.getDateTrasaction() + " montant :"
									+ transa.getMontant());
						}

					}
				}
				break;
			// RECHERCHER UN COMPTE A PARTIR DU NUMERO D'IDENTIFICATION
			case '6':
				int nombrecpt = 0;
				System.out.println("saisir le numero d'identifiant.");
				int numId = Integer.parseInt(saisir.nextLine());
				for (CompteClient cpt : listCompteClient) {
					if (cpt.getNumIDCompte() == numId) {
						nombrecpt = nombrecpt + 1;
					}

				}
				System.out.println("le client a " + nombrecpt + " compte");

				break;

			default:
				//
				break;
			}
			menuchoisi = '0';
		}

	}

	public static void main(String[] args) {
		new ApplicationBanque().lancerApp();
	}
}
