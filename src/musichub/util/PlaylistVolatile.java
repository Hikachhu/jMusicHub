package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PlaylistVolatile{
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
    System.out.println("___________________________________________________");
    System.out.println("Contenu que vous pouvez ajouter:");
    System.out.println("Chanson:");
    System.out.println(chansonvolatile);

    System.out.println("Livre audio:");
    System.out.println(livreaudiovolatile);

    do {
      Scanner clavier = new Scanner(System.in);
      System.out.println("c ajouter chanson\nl ajouter livreaudio\nEntrez une commande:");
      c = clavier.next().charAt(0);
      System.out.println("selectionnez l'id à ajouter:");
      switch (c) {
        case 'c':
          number = clavier.nextInt();
          Ensemble.add(chansonvolatile.get(number));
          break;

        case 'l':
          number = clavier.nextInt();
          Ensemble.add(livreaudiovolatile.get(number));
          break;
      }
    } while (c!='q');
  }

  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }

}
