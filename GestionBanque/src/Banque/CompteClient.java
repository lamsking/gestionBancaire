package Banque;
//creation de la classe compte du client
public class CompteClient {
	int numCompte;
	int numIdCompte;
	String nomTitulaireCompte;
	float soldeCompte;
	float taux;

	//appelons les getter et les setters
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public int getNumIDCompte() {
		return numIdCompte;
	}
	public void setNumIDCompte(int numIDCompte) {
		this.numIdCompte = numIDCompte;
	}
	public String getNomTitulaireCompte() {
		return nomTitulaireCompte;
	}
	public void setNomTitulaireCompte(String nomTitulaireCompte) {
		this.nomTitulaireCompte = nomTitulaireCompte;
	}
	public float getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}

	//creation d'une methode qui permet d'enregistrer un nouveau compte avec ces parametre.
	public void enregistrerCompteClient(int numCompte,int numIdCompte,String nomTitulaireCompte ,float soldeCompte,float taux){
		CompteClient compte=new CompteClient();
		compte.setNumCompte(numCompte);
		compte.setNumIDCompte(numIdCompte);
		compte.setNomTitulaireCompte(nomTitulaireCompte);
		compte.setSoldeCompte(soldeCompte);
		compte.setTaux(taux);
		
		
	}
	
	
	
	
	
	
}
