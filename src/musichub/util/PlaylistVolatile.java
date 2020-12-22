package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class PlaylistVolatile {
  public ArrayList<Stockage> Ensemble = new ArrayList<Stockage>();

  public void addUser(){

    Scanner clavier = new Scanner(System.in);
    System.out.println("Entrez le Nom:");
    String Nom=clavier.nextLine();

    Playlist nouveau= new Playlist(Nom,Ensemble.size()+1);
    Ensemble.add(nouveau);
  }

  public void addContenu(LivreAudioVolatile livreaudiovolatile,ChansonVolatile chansonvolatile){

    int number;
    char c;
    Scanner clavier = new Scanner(System.in);
    System.out.println("___________________________________________________");
    System.out.println("Titre de la playlist:");
    String Titre =clavier.nextLine();
    Playlist nouvelle = new Playlist(Titre,Ensemble.size()+1);

    System.out.println("Contenu que vous pouvez ajouter:");
    System.out.println("Chanson:");
    System.out.println(chansonvolatile);

    System.out.println("Livre audio:");
    System.out.println(livreaudiovolatile);

    do {
      System.out.println("c ajouter chanson\nl ajouter livreaudio\nEntrez une commande:");
      c = clavier.next().charAt(0);
      System.out.println("selectionnez l'id à ajouter:");
      switch (c) {
        case 'c':
          number = clavier.nextInt();
          nouvelle.add(chansonvolatile.get(number));
          break;

        case 'l':
          number = clavier.nextInt();
          nouvelle.add(livreaudiovolatile.get(number));
          break;
      }
    } while (c!='q');
    Ensemble.add(nouvelle);
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
