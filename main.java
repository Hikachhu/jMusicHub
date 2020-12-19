class main{
  public static void main(String[] args) {
    Chanson stock = new Chanson("Dernier texto",110,1,"Artiste","musique.mp4",1);
    Chanson stock1 = new Chanson("Chanson deux",120,2,"Artiste","musique.mp4",2);
    Playlist playlist = new Playlist("Liste de lecture",1);
    LivreAudio livreaudio = new LivreAudio("livreaudio1",643,1,"Moi meme","LivreAudio.mp3",1,2);
    System.out.println(livreaudio);
    playlist.add(stock);
    playlist.add(stock1);
    playlist.Affiche();
  }
}
