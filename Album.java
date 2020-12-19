import java.util.ArrayList;

class Album extends Stockage{
  private String Artiste;
  private int DateSortie;
  private ArrayList<Stockage> Ensemble;

  Album(String Titre,int Duree,int ID,String Artiste,int DateSortie){
    super(Titre,Duree,ID);
    Ensemble = new ArrayList<Stockage>();
    this.Artiste=Artiste;
    this.DateSortie=DateSortie;
  }

  public void Affiche(){
    for (Stockage Courant : Ensemble ) {
      System.out.println(Courant);
    }
  }

  public void add(Stockage stock){
    Ensemble.add(stock);
  }

}
