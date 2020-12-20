package musichub.business;
import musichub.business.*;

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

  public String toString(){
    return "Titre="+Titre +" Duree="+getDureeMin()+" ID="+ID+" Auteur="+ Auteur+" Contenu="+ Contenu+" langue="+ langue+" categorie=" +categorie;
  }
}
