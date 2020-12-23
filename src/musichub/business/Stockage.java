package musichub.business;
import musichub.business.*;
import java.io.Serializable;

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

public abstract class Stockage implements Serializable{
  protected String Titre;
  protected int ID;

  public Stockage(String Titre,int ID){
    this.Titre=Titre;
    this.ID=ID;
  }

  public String getTitre(){
    return this.Titre;
  }

  public int getID(){
    return this.ID;
  }
  public Element getElement(Document document){
    Element client = document.createElement("Stockage");

      Element Titre = document.createElement("Titre");
      Titre.appendChild(document.createTextNode(getTitre()));
      client.appendChild(Titre);

      Element ID = document.createElement("ID");
      ID.appendChild(document.createTextNode(Integer.toString(getID())));
      client.appendChild(ID);

      return client;
  }
}
