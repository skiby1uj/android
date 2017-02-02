package com.example.budzetdomowy2_0;

public class rowWydatkiNiePlanowane {
	//public int ID;
	public String opis;
	public String koszt;
	
	public rowWydatkiNiePlanowane(){
		
	}
	
	public rowWydatkiNiePlanowane(
String opis, int koszt){
		//this.ID = ID;
		this.opis = opis;
		this.koszt = koszt + " zl";
	}
}
