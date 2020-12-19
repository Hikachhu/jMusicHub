package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Album extends Stockage{
  private String Artiste;
  private int DateSortie;
  private ArrayList<Chanson> Ensemble;

  public Album(String Titre,int Duree,int ID,String Artiste,int DateSortie){
    super(Titre,Duree,ID);
    Ensemble = new ArrayList<Chanson>();
    this.Artiste=Artiste;
    this.DateSortie=DateSortie;
  }
  /**
   * Affiche l'ensemble des element de la liste
   */
  public void Affiche(){
    for (Chanson Courant : Ensemble ) {
      System.out.println(Courant);
    }
  }

  public void add(Chanson stock){
    Ensemble.add(stock);
  }

  public void addUser(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le titre:");
    String Titre=clavier.nextLine();
    System.out.println("Duree:");
    int Duree=clavier.nextInt();
    System.out.println("Artiste:");
    String Artiste=clavier.nextLine();
    System.out.println("Contenu:");
    String Contenu=clavier.nextLine();
    System.out.println("Genre:");
    int genre=clavier.nextInt();

    Chanson nouveau= new Chanson(Titre,Duree,1,Artiste,Contenu,genre);
    Ensemble.add(nouveau);
  }

  public String toString(){
    String s="";
    for (Chanson Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }
}
