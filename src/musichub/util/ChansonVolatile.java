package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ChansonVolatile{
  public ArrayList<Chanson> Ensemble = new ArrayList<Chanson>();

  public void addUser(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le titre:");
    String Titre=clavier.nextLine();
    System.out.println("Duree:");
    int Duree=clavier.nextInt();
    clavier.nextLine();
    System.out.println("Artiste:");
    String Artiste=clavier.nextLine();
    System.out.println("Contenu:");
    String Contenu=clavier.nextLine();
    System.out.println("Genre:");
    int genre=clavier.nextInt();

    Chanson nouveau= new Chanson(Titre,Duree,Ensemble.size()+1,Artiste,Contenu,genre);
    Ensemble.add(nouveau);
    System.out.println("Chanson ajoutée");
  }

  public void add(Chanson nouveau){
    Ensemble.add(nouveau);
  }

  public String toString(){
    String s="";
    for (Chanson Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }

  public ArrayList<Chanson> getEnsemble(){
    return Ensemble;
  }

  public Chanson get(int number){
    return Ensemble.get(number);
  }

}
