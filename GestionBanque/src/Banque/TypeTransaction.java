package Banque;

public enum TypeTransaction {
	  //Objets directement construits
	  depot("depot"),
	  retrait("retrait");
	   
	  private String type = "";
	   
	  //Constructeur
	  TypeTransaction(String type){
	    this.type = type;
	  }
	   
	  public String toString(){
	    return type;
	  }
	}
