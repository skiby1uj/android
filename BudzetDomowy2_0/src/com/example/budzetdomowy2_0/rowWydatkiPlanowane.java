package com.example.budzetdomowy2_0;

public class rowWydatkiPlanowane {
	//public int ID;
	public String opis;
	public String koszt;
	
	public rowWydatkiPlanowane(){
		
	}
	
	public rowWydatkiPlanowane(/*int ID ,*/String opis, int koszt){
		//this.ID = ID;
		this.opis = opis;
		this.koszt = koszt + " zl";
	}
}
