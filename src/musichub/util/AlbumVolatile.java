package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AlbumVolatile {
  public ArrayList<Album> Ensemble = new ArrayList<Album>();

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

  public void add(int AlbumNumber,Chanson Aajouter){
    Album nouveau=Ensemble.get(AlbumNumber);
    nouveau.add(Aajouter);
  }

  public void TriMusique(int AlbumNumber){
    (Ensemble.get(AlbumNumber)).Tri();
  }

  public void add(Album nouveau){
    Ensemble.add(nouveau);
  }

  public String toString(){
    String s="";
    for (Album Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }

  public ArrayList<Album> getEnsemble(){
    return Ensemble;
  }

  public Album get(int number){
    return Ensemble.get(number);
  }

  public ArrayList<Album> Trie(){
    ArrayList<Album> Trier= new ArrayList<Album>(Ensemble);
    Trier.sort((p1, p2) -> Integer.valueOf(p1.getDateSortie()).compareTo(p2.getDateSortie()));
    return Trier;
  }

  public ArrayList<Album> TrieChanson(){
    ArrayList<Album> Trier= new ArrayList<Album>(Ensemble);
    for (Album album: Trier){
      album.Tri();
    }
    return Trier;
  }

}
