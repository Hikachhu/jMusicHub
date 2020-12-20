package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LivreAudioVolatile implements Listing{
  public ArrayList<Stockage> Ensemble = new ArrayList<Stockage>();

  public void addUser(){

    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le Titre:");
    String Titre=clavier.nextLine();
    System.out.println("Entrez la Duree:");
    int Duree=clavier.nextInt();
    System.out.println("Entrez l'auteur :");
    String Auteur=clavier.nextLine();
    clavier.nextLine();
    System.out.println("Entrez le Contenu:");
    String Contenu=clavier.nextLine();
    System.out.println("Entrez la langue:");
    int langue=clavier.nextInt();
    System.out.println("Entrez la categorie :");
    int categorie=clavier.nextInt();

    LivreAudio nouveau =  new LivreAudio(Titre,Duree,Ensemble.size()+1,Auteur,Contenu,langue,categorie);
    Ensemble.add(nouveau);
  }

  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }

  public void add(Stockage nouveau){
    Ensemble.add(nouveau);
  }

  public Stockage get(int number){

    return Ensemble.get(number-1);

  }

}
