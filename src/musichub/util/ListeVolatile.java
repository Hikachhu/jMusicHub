package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ListeVolatile implements Listing{
  public void add(Stockage nouvelle){
    Ensemble.add(nouvelle);
  }

  public void addUserChanson(){
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

    Chanson nouveau= new Chanson(Titre,Duree,Ensemble.size()+1,Artiste,Contenu,genre);
    Ensemble.add(nouveau);
  }

  public void addUserLivreAudio(){

    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le Titre:");
    String Titre=clavier.nextLine();
    System.out.println("Entrez la Duree:");
    int Duree=clavier.nextInt();
    System.out.println("Entrez l'auteur :");
    String Auteur=clavier.nextLine();
    System.out.println("Entrez le Contenu:");
    String Contenu=clavier.nextLine();
    System.out.println("Entrez la langue:");
    int langue=clavier.nextInt();
    System.out.println("Entrez la categorie :");
    int categorie=clavier.nextInt();

    LivreAudio nouveau =  new LivreAudio(Titre,Duree,Ensemble.size()+1,Auteur,Contenu,langue,categorie);
    Ensemble.add(nouveau);
  }

  public void addUserAlbum(){

    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le Titre:");
    String Titre=clavier.nextLine();
    System.out.println("Entrez la Duree:");
    int Duree=clavier.nextInt();
    System.out.println("Entrez l'Artiste :");
    String Artiste=clavier.nextLine();
    System.out.println("Entrez la Date de sortie:");
    int DateSortie=clavier.nextInt();

    Album nouveau = new Album(Titre,Duree,Ensemble.size()+1,Artiste,DateSortie);
    Ensemble.add(nouveau);
  }

  public void addUserPlaylist(){

    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le Nom:");
    String Nom=clavier.nextLine();

    Playlist nouveau= new Playlist(Nom,Ensemble.size()+1);
    Ensemble.add(nouveau);

  }

  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }
}
