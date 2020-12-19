import java.util.ArrayList;

class Playlist {
  private ArrayList<Stockage> Ensemble;
  private String Nom;
  private int ID;

  Playlist(String Nom,int ID){
    Ensemble = new ArrayList<Stockage>();
    this.Nom=Nom;
    this.ID=ID;
  }
  public void Affiche(){
    for (Stockage Courant : Ensemble ) {
      System.out.println(Courant);
    }
  }

  public void add(Stockage stock){
    Ensemble.add(stock);
  }

  public String toString(){
    String s="";
    for (Stockage Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }
}
