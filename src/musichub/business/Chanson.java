package musichub.business;
import musichub.business.*;

public class Chanson extends Stockage{
  private String Artiste;
  private String Contenu;
  Genre genre;
  public Chanson(String Titre,int Duree,int ID,String Artiste,String Contenu,int genre){
    super(Titre,Duree,ID);
    this.Artiste=Artiste;
    this.Contenu=Contenu;
    this.genre=Genre.values()[genre];
  }
  public String toString(){
    return "Titre ="+getTitre()+" | Duree ="+getDureeMin()+" | ID= "+getID()+" | Artiste = "+Artiste+" | Contenu = "+ Contenu+ " | genre = "+ genre;
  }

  public Genre getGenre(){
    return this.genre;
  }
}
