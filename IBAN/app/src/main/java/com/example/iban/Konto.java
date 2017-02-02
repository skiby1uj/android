package com.example.iban;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

@SuppressWarnings("unused")
class Konto{
    String nr = "";
   
    boolean czyPoprawny(){
       
        nr = nr.replace(" ", "");
        String tmp = nr;
        if(tmp.length() != 28){
            return false;
            //System.out.println(nr + " " + "BLEDNY");
        }
        else{
            //System.out.println(nr.substring(0, 2));
            if(tmp.substring(0, 2).equals("PL")){// polski numer
               // System.out.println(tmp);
                tmp = tmp.substring(4) +"2521" +  tmp.substring(2, 4);
                //System.out.println("tu: " + Integer.parseInt(nr));
                BigInteger i = new BigInteger(tmp);
                BigInteger odp = new BigInteger("1");
                BigInteger m = new BigInteger("97");
               // System.out.println(i.mod(m));
                if(i.mod(m).equals(odp)){//nr poprawny
                    return true;
                }
                else//nr niepoprawny
                    return false;  
            }
            else// nie polski numer
                return false; 
        }
    }
}