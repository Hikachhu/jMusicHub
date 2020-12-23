package musichub.business;
import musichub.business.*;

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

import musichub.util.*;
import musichub.business.*;

public class Chanson extends Stockage{
  private String Artiste;
  private String Contenu;
  protected int Duree;
  Genre genre;
  public Chanson(String Titre,int Duree,int ID,String Artiste,String Contenu,int genre){
    super(Titre,ID);
    this.Artiste=Artiste;
    this.Contenu=Contenu;
    this.Duree=Duree;
    this.genre=Genre.values()[genre];
  }

  public String getArtiste(){
    return this.Artiste;
  }

  public String getContenu(){
    return this.Contenu;
  }

  public Genre getGenre(){
    return this.genre;
  }

  public int getGenreNumber(){
    return (this.genre).ordinal();
  }

  public int getDureeSec(){
    return this.Duree;
  }

  public String getDureeMin(){
    int min=(this.Duree)/60;
    int secondes=((this.Duree)%60);
    return String.valueOf(min)+"m"+String.valueOf(secondes)+"s";
  }
  public String toString(){
    return "Titre ="+getTitre()+" | Duree ="+getDureeMin()+" | ID= "+getID()+" | Artiste = "+Artiste+" | Contenu = "+ Contenu+ " | genre = "+ getGenre();
  }

  public Element getElement(Document document){
    Element client = document.createElement("Chanson");

      Element Titre = document.createElement("Titre");
      Titre.appendChild(document.createTextNode(getTitre()));
      client.appendChild(Titre);

      Element Duree = document.createElement("Duree");
      Duree.appendChild(document.createTextNode(Integer.toString(getDureeSec())));
      client.appendChild(Duree);

      Element ID = document.createElement("ID");
      ID.appendChild(document.createTextNode(Integer.toString(getID())));
      client.appendChild(ID);

      Element Artiste = document.createElement("Artiste");
      Artiste.appendChild(document.createTextNode(getArtiste()));
      client.appendChild(Artiste);

      Element Contenu = document.createElement("Contenu");
      Contenu.appendChild(document.createTextNode(getContenu()));
      client.appendChild(Contenu);

      Element Genre = document.createElement("Genre");
      Genre.appendChild(document.createTextNode(Integer.toString(getGenreNumber())));
      client.appendChild(Genre);
      return client;
  }

}
