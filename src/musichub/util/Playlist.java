package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

import org.w3c.dom.*;
import java.io.IOException;
import java.io.File;

public class Playlist extends Stockage implements Listing{
  public ArrayList<Stockage> Ensemble = new ArrayList<Stockage>();

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
    String s="Nom: "+getTitre()+" ID: "+getID()+"\n";
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

  public Element getElement(Document document){
    Element client = document.createElement("Playlist");

      Element Titre = document.createElement("Titre");
      Titre.appendChild(document.createTextNode(getTitre()));
      client.appendChild(Titre);

      Element ID = document.createElement("ID");
      ID.appendChild(document.createTextNode(Integer.toString(getID())));
      client.appendChild(ID);

      Element ListeAudios = document.createElement("ListeAudios");

      for (Stockage Actuel : Ensemble ) {
        ListeAudios.appendChild(Actuel.getElement(document));
      }
      client.appendChild(ListeAudios);

      return client;
  }

}
