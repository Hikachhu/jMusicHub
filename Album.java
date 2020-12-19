import java.util.ArrayList;

class Album extends Stockage{
  private String Artiste;
  private int DateSortie;
  private ArrayList<Chanson> Ensemble;

  Album(String Titre,int Duree,int ID,String Artiste,int DateSortie){
    super(Titre,Duree,ID);
    Ensemble = new ArrayList<Chanson>();
    this.Artiste=Artiste;
    this.DateSortie=DateSortie;
  }

  public void Affiche(){
    for (Chanson Courant : Ensemble ) {
      System.out.println(Courant);
    }
  }

  public void add(Chanson stock){
    Ensemble.add(stock);
  }

  public String toString(){
    String s="";
    for (Chanson Courant : Ensemble ) {
      s+=(Courant+"\n");
    }
    return s;
  }
}
