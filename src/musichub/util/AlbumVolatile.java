package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AlbumVolatile {
  public ArrayList<Stockage> Ensemble = new ArrayList<Stockage>();

  public void addUser(){

    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le Titre:");
    String Titre=clavier.nextLine();
    System.out.println("Entrez la Duree:");
    int Duree=clavier.nextInt();
    clavier.nextLine();
    System.out.println("Entrez l'Artiste :");
    String Artiste=clavier.nextLine();
    System.out.println("Entrez la Date de sortie:");
    int DateSortie=clavier.nextInt();

    Album nouveau = new Album(Titre,Duree,Ensemble.size()+1,Artiste,DateSortie);
    Ensemble.add(nouveau);
  }

  public void add(int AlbumNumber,Stockage Aajouter){
    Album nouveau=(Album)Ensemble.get(AlbumNumber);
    nouveau.add(Aajouter);
  }

  public void add(Album nouveau){
    Ensemble.add(nouveau);
  }

  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }

  public ArrayList<Stockage> getEnsemble(){
    return Ensemble;
  }

  public Stockage get(int number){
    return Ensemble.get(number);
  }
}
