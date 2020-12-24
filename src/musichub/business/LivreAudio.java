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


public class LivreAudio extends Stockage{
  private String Auteur;
  private String Contenu;
  protected int Duree;
  Langues langue;
  Categorie categorie;

  public LivreAudio(String Titre,int Duree,int ID,String Auteur,String Contenu,int langue,int categorie){
    super(Titre,ID);
    this.Auteur=Auteur;
    this.Contenu=Contenu;
    this.Duree=Duree;
    this.categorie=Categorie.values()[categorie];
    this.langue=Langues.values()[langue];
  }

  public int getDureeSec(){
    return this.Duree;
  }

  public String getDureeMin(){
    int min=(this.Duree)/60;
    int secondes=((this.Duree)%60);
    return String.valueOf(min)+"m"+String.valueOf(secondes)+"s";
  }

  public String getAuteur(){
    return this.Auteur;
  }

  public String getContenu(){
    return this.Contenu;
  }

  public int getCategorieNumber(){
    return (this.categorie).ordinal();
  }

  public int getLangueNumber(){
    return (this.langue).ordinal();
  }

  public int compareTo(Object externe) {
      return getTitre().compareTo(((LivreAudio)externe).getTitre());
  }

  public String toString(){
    return "Titre="+Titre +" Duree="+getDureeMin()+" ID="+ID+" Auteur="+ Auteur+" Contenu="+ Contenu+" langue="+ langue+" categorie=" +categorie;
  }

  public Element getElement(Document document){
    Element client = document.createElement("LivreAudio");

      Element Titre = document.createElement("Titre");
      Titre.appendChild(document.createTextNode(getTitre()));
      client.appendChild(Titre);

      Element Duree = document.createElement("Duree");
      Duree.appendChild(document.createTextNode(Integer.toString(getDureeSec())));
      client.appendChild(Duree);

      Element ID = document.createElement("ID");
      ID.appendChild(document.createTextNode(Integer.toString(getID())));
      client.appendChild(ID);

      Element Artiste = document.createElement("Auteur");
      Artiste.appendChild(document.createTextNode(getAuteur()));
      client.appendChild(Artiste);

      Element Contenu = document.createElement("Contenu");
      Contenu.appendChild(document.createTextNode(getContenu()));
      client.appendChild(Contenu);

      Element Langue = document.createElement("Langue");
      Langue.appendChild(document.createTextNode(Integer.toString(getCategorieNumber())));
      client.appendChild(Langue);

      Element Categorie = document.createElement("Categorie");
      Categorie.appendChild(document.createTextNode(Integer.toString(getLangueNumber())));
      client.appendChild(Categorie);

      return client;
  }
}
