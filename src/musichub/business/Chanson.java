package musichub.business;
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

}
