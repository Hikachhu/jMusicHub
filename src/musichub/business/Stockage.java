package musichub.business;
import musichub.business.*;

public class Stockage{
  protected String Titre;
  protected int Duree;
  protected int ID;

  public Stockage(String Titre,int Duree,int ID){
    this.Titre=Titre;
    this.Duree=Duree;
    this.ID=ID;
  }
  public String getTitre(){
    return this.Titre;
  }
  public int getDureeSec(){
    return this.Duree;
  }
  public String getDureeMin(){
    int min=(this.Duree)/60;
    int secondes=((this.Duree)%60);
    return String.valueOf(min)+"m"+String.valueOf(secondes)+"s";
  }
  public int getID(){
    return this.ID;
  }
}
