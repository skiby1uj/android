package com.example.budzetdomowy;

public class rowDomownik {
	public String dane;
	public String wydatek;
	public String cena;

	
	public rowDomownik() {
		// TODO Auto-generated constructor stub
	}
	
	/*public rowDomownik(String dane, String wydatek, int cena){
		this.dane = dane;
		this.wydatek = wydatek;
		this.cena = cena;
	}*/
	
	public rowDomownik(String dane, String zarobki){
		this.dane = dane;
		cena = zarobki;
	}
	
	
}
