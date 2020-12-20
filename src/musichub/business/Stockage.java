package musichub.business;
import musichub.business.*;

public abstract class Stockage{
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
