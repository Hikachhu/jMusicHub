package musichub.main;
import musichub.util.*;
import musichub.business.*;
import musichub.main.*;

import java.util.Scanner;

class main{
  public static void main(String[] args) {
    char c='h';
    Chanson stock = new Chanson("Dernier texto",110,1,"Artiste","musique.mp4",1);
    Chanson stock1 = new Chanson("Chanson deux",120,2,"Artiste","musique.mp4",2);
    Playlist playlist = new Playlist("Liste de lecture",1);
    LivreAudio livreaudio = new LivreAudio("livreaudio1",643,1,"Moi meme","LivreAudio.mp3",1,2);
    playlist.add(stock);
    playlist.add(stock1);
    playlist.add(livreaudio);
    System.out.println(playlist);
    do{
      Scanner clavier = new Scanner(System.in);
      switch (c) {
        case 'c':
          break;
        case 'a':
          break;
        case '+':
          break;
        case 'l':
          break;
        case 'p':
          break;
        case '-':
          break;
        case 's':
          break;
        case 'h':
          System.out.println("Commandes disponibles");
          System.out.println("« c » : rajout d’une nouvelle chanson");
          System.out.println("« a » : rajout d’un nouvel album");
          System.out.println("« + » : rajout d’une chanson existante à un album");
          System.out.println("« l » : rajout d’un nouveau livre audio");
          System.out.println("« p » : création d’une nouvelle playlist à partir de chansons et livres audio existants");
          System.out.println("« - » : suppression d’une playlist");
          System.out.println("« s » : sauvegarde des playlists, des albums, des chansons et des livres audios dans les fichiers xml respectifs");
          System.out.println("« h » : aide avec les détails des commandes précédentes");
          System.out.println("« q » : quitte le programme");
          break;
      }
      c = clavier.next().charAt(0);
    }while (c!='q');
  }
}
