class LivreAudio extends Stockage{
  private String Auteur;
  private String Contenu;
  Langues langue;
  Categorie categorie;

  LivreAudio(String Titre,int Duree,int ID,String Auteur,String Contenu,int langue,int categorie){
    super(Titre,Duree,ID);
    this.Auteur=Auteur;
    this.Contenu=Contenu;
    this.categorie=Categorie.values()[categorie];
    this.langue=Langues.values()[langue];
  }

  public String toString(){
    return "Titre="+Titre +" Duree="+getDureeMin()+" ID="+ID+" Auteur="+ Auteur+" Contenu="+ Contenu+" langue="+ langue+" categorie=" +categorie;
  }
}
