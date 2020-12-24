package musichub.util;
import musichub.util.*;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

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

public class Album extends Stockage{
  private String Artiste;
  private int DateSortie;
  protected int Duree;
  public ArrayList<Chanson> EnsembleChanson = new ArrayList<Chanson>();

  public Album(String Titre,int Duree,int ID,String Artiste,int DateSortie){
    super(Titre,ID);
    this.Artiste=Artiste;
    this.DateSortie=DateSortie;
    this.Duree=Duree;
  }
  public int getDureeSec(){
    return this.Duree;
  }

  public String getDureeMin(){
    int min=(this.Duree)/60;
    int secondes=((this.Duree)%60);
    return String.valueOf(min)+"m"+String.valueOf(secondes)+"s";
  }

  public void add(Chanson stock){
    EnsembleChanson.add(stock);
  }

  public ArrayList<Chanson> getEnsemble(){
    return EnsembleChanson;
  }

  public int getDateSortie(){
    return this.DateSortie;
  }

  public String toString(){
    String s="Album: "+getTitre()+" ID: "+getID()+" Artiste: "+Artiste+" DateSortie: "+DateSortie+" Duree: "+getDureeMin()+"\n";
    for (Chanson Courant : EnsembleChanson ) {
      s+=(Courant+"\n");
    }
    return s;
  }

  public String getArtiste(){
    return this.Artiste;
  }

  public Element getElement(Document document){

      Element AlbumElem = document.createElement("Album");
        Element Titre = document.createElement("Titre");
        Titre.appendChild(document.createTextNode(getTitre()));
        AlbumElem.appendChild(Titre);

        Element Duree = document.createElement("Duree");
        Duree.appendChild(document.createTextNode(Integer.toString(getDureeSec())));
        AlbumElem.appendChild(Duree);

        Element ID = document.createElement("ID");
        ID.appendChild(document.createTextNode(Integer.toString(getID())));
        AlbumElem.appendChild(ID);

        Element DateSortie = document.createElement("DateSortie");
        DateSortie.appendChild(document.createTextNode(Integer.toString(getDateSortie())));
        AlbumElem.appendChild(DateSortie);

        Element Artiste = document.createElement("Artiste");
        Artiste.appendChild(document.createTextNode(getArtiste()));
        AlbumElem.appendChild(Artiste);

        Element ListeChanson = document.createElement("ListeChanson");

        for(Chanson  ChansonEcrire : EnsembleChanson){
          ListeChanson.appendChild(ChansonEcrire.getElement(document));
        }

        AlbumElem.appendChild(ListeChanson);
    return AlbumElem;
  }

  public ArrayList<Chanson> Tri(){
   ArrayList<Chanson> Trier= new ArrayList<Chanson>(EnsembleChanson);
   Trier.sort((p1, p2) -> p1.getGenre().compareTo(p2.getGenre()));
   return Trier;
  }
}
