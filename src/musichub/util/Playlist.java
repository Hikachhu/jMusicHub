package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist extends Stockage implements Listing{
  public Playlist(String Nom,int ID){
    super(Nom,ID);
  }
  public void Affiche(){
    for (Stockage Courant : Ensemble ) {
      System.out.println(Courant);
    }
  }
  /**
   * Ajoute un element mis en parametre dans la liste
   * @param stock parametre à rajouter
   */
  public void add(Stockage stock){
    Ensemble.add(stock);
  }

  /**
   * Fonction d'affichage par defaut
   * @return Renvoi la chaine de texte à afficher
   */
  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }
  /**
   * Permet d'ajouter une chanson dans la liste a partir d'entrée utilisateur
   */
  public void addUser(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le titre:");
    String Titre=clavier.nextLine();
    System.out.println("Duree:");
    int Duree=clavier.nextInt();
    System.out.println("Artiste:");
    clavier.nextLine();
    String Artiste=clavier.nextLine();
    System.out.println("Contenu:");
    String Contenu=clavier.nextLine();
    System.out.println("Genre:");
    int genre=clavier.nextInt();

    Chanson nouveau= new Chanson(Titre,Duree,Ensemble.size()+1,Artiste,Contenu,genre);
    Ensemble.add(nouveau);
  }
}
