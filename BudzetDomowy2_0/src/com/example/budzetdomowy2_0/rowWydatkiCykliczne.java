package com.example.budzetdomowy2_0;

public class rowWydatkiCykliczne {
	//public int ID;
	public String opis;
	public String koszt;
	
	public rowWydatkiCykliczne() {
		// TODO Auto-generated constructor stub
	}
	
	public rowWydatkiCykliczne(/*int ID ,*/String opis, int koszt){
		//this.ID = ID;
		this.opis = opis;
		this.koszt = koszt + " zl";
	}
}
