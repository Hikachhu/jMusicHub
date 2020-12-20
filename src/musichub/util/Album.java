package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Album extends Stockage implements Listing{
  private String Artiste;
  private int DateSortie;
  protected int Duree;

  public Album(String Titre,int Duree,int ID,String Artiste,int DateSortie){
    super(Titre,ID);
    this.Artiste=Artiste;
    this.DateSortie=DateSortie;
    this.Duree=Duree;
  }
  public int getDureeSec(){
    return this.Duree;
  }

  public String getDureeMin(){
    int min=(this.Duree)/60;
    int secondes=((this.Duree)%60);
    return String.valueOf(min)+"m"+String.valueOf(secondes)+"s";
  }
  public void add(Stockage stock){
    Ensemble.add(stock);
  }

  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }
}
