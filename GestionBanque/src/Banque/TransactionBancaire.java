package Banque;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


//creation de la classe transaction
public class TransactionBancaire {
int numTransaction;
int numCompte;
String dateTrasaction;
TypeTransaction typeTransaction;
ApplicationBanque b;
float montant;



public TransactionBancaire(int numTransaction, int numCompte, TypeTransaction typeTransaction, String dateTrasaction,float montant) {
	super();
	this.numTransaction = numTransaction;
	this.numCompte = numCompte;
	this.dateTrasaction = dateTrasaction;
	this.typeTransaction = typeTransaction;
	this.montant = montant;
}

public TransactionBancaire()
{
	
}



public int getNumTransaction() {
	return numTransaction;
}



public void setNumTransaction(int numTransaction) {
	this.numTransaction = numTransaction;
}



public int getNumCompte() {
	return numCompte;
}



public void setNumCompte(int numCompte) {
	this.numCompte = numCompte;
}



public String getDateTrasaction() {
	
	return dateTrasaction;
}



public void setDateTrasaction() {
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
	this.dateTrasaction = format.format(new Date());
}

public TypeTransaction getTypeTransaction() {
	return typeTransaction;
}

public void setTypeTransaction(TypeTransaction typeTransaction) {
	this.typeTransaction = typeTransaction;
}

public float getMontant() {
	return montant;
}
public void setMontant(float montant) {
	this.montant = montant;
}



public ApplicationBanque getB() {
	return b;
}



public void setB(ApplicationBanque b) {
	this.b = b;
}



public void enregTransaction (){
	if(getB().getCompteAvecNum(numCompte)!=null){
	if((this.typeTransaction==TypeTransaction.retrait) && (getB().getCompteAvecNum(this.numCompte).getSoldeCompte()>this.getMontant())){
		getB().getCompteAvecNum(this.numCompte).setSoldeCompte(getB().getCompteAvecNum(this.numCompte).getSoldeCompte()-this.getMontant());
		System.out.println("La transaction a été éffectué avec succès");
	}else if((this.typeTransaction==TypeTransaction.depot)){
		getB().getCompteAvecNum(this.numCompte).setSoldeCompte(getB().getCompteAvecNum(this.numCompte).getSoldeCompte()+this.getMontant());
		System.out.println("Solde insuffisant pour cette opération");
	}else{
		System.out.println("La transaction a échoué car la solde est insuffisant");
	}
}else{
	System.out.println("Transaction échoué , Le compte n'a pas été trouvé!");
}
}
}

