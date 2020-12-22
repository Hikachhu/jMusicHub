package musichub.business;
import musichub.business.*;
import java.io.Serializable;

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
}
