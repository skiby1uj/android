package com.example.budzetdomowy2_0;

public class rowPrzychodyRodziny {
	//public String ID;
	public String dane;
	public String zarobki;
	
	public rowPrzychodyRodziny(){
		
	}
	
	public rowPrzychodyRodziny(/*int ID ,*/String imie, String nazwisko, int zarobki){
		//this.ID = ID + "";
		dane = imie + "\n" + nazwisko;
		this.zarobki = zarobki + " zl";
	}
}
