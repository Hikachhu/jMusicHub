package musichub.main;
import musichub.util.*;
import musichub.business.*;
import musichub.main.*;

import java.util.Scanner;

class main{

  public static void main(String[] args) {
    char c='h';

    // Chanson stock1 = new Chanson("Chanson deux",120,2,"Artiste","musique.mp4",2);
    // Playlist playlist = new Playlist("Liste de lecture",1);
    // LivreAudio livreaudio = new LivreAudio("livreaudio1",643,1,"Moi meme","LivreAudio.mp3",1,2);
    // playlist.add(stock);
    // playlist.add(stock1);
    // playlist.add(livreaudio);
    // System.out.println(playlist);

    Scanner clavier = new Scanner(System.in);
    int ChansonNumber;
    ChansonVolatile     ListeChanson    = new ChansonVolatile();
    LivreAudioVolatile  ListeLivreAudio = new LivreAudioVolatile();
    AlbumVolatile       ListeAlbum      = new AlbumVolatile();
    PlaylistVolatile    ListePlaylist   = new PlaylistVolatile();

    WriteChansonVolatile    FichierChansons =   new WriteChansonVolatile();
    ListeChanson  = FichierChansons.readXML("Chanson.xml");
    WriteAlbumVolatile FichierAlbums = new WriteAlbumVolatile();
    ListeAlbum  = FichierAlbums.readXML("Albums.xml");
    WriteLivreAudioVolatile FichierLivreAudio = new WriteLivreAudioVolatile();
    ListeLivreAudio  = FichierLivreAudio.readXML("LivreAudio.xml");

    // LivreAudio lstock = new LivreAudio("Livre1",123,1,"Auteur1","Livre1.mp4",1,1);
    // LivreAudio lstock1 = new LivreAudio("Livre1",123,2,"Auteur1","Livre1.mp4",1,1);
    // LivreAudio lstock2 = new LivreAudio("Livre1",123,3,"Auteur1","Livre1.mp4",1,1);
    // LivreAudio lstock3 = new LivreAudio("Livre1",123,4,"Auteur1","Livre1.mp4",1,1);
    // ListeLivreAudio.add(lstock);
    // ListeLivreAudio.add(lstock1);
    // ListeLivreAudio.add(lstock2);
    // ListeLivreAudio.add(lstock3);

    // Album astock = new Album("Album1",134,1,"Createur d'album",1989);
    // ListeAlbum.add(astock);
    do{
      switch (c) {
        case 'd':
          System.out.println("Chanson:");
          System.out.println(ListeChanson);

          System.out.println("\nLivre audio:");
          System.out.println(ListeLivreAudio);

          System.out.println("\nAlbum :");
          System.out.println(ListeAlbum);

          System.out.println("\nPlaylist:");
          System.out.println(ListePlaylist);
          break;

        case 'c':
          ListeChanson.addUser();
          break;

        case 'a':
          ListeAlbum.addUser();
          break;

        case '+':
          System.out.println("Liste des albums et leurs contenus:\n " +ListeAlbum);
          System.out.println("Listes des chansons disponibles: \n"    +ListeChanson);
          System.out.println("Selectionnez l'album où ajouter des musiques");
          int AlbumNumber=clavier.nextInt();
          System.out.println("Selectionnez un id à ajouter");
          ChansonNumber=clavier.nextInt();
          ListeAlbum.add(AlbumNumber,(ListeChanson.get(ChansonNumber)));

          break;

        case 'l':
          ListeLivreAudio.addUser();
          break;

        case 'p':
          ListePlaylist.addContenu(ListeLivreAudio,ListeChanson);
          break;

        case '-':
          break;

        case 's':
          FichierChansons.writeXML("Chanson.xml",ListeChanson);
          FichierAlbums.writeXML("Albums.xml",ListeAlbum);
          FichierLivreAudio.writeXML("LivreAudio.xml",ListeLivreAudio);

          break;

        case 'h':
          System.out.println("Commandes disponibles");
          System.out.println("« d » : Affiche toutes les listes");
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
      System.out.println("___________________________________________________");
      System.out.println("Entrez une commande:");
      c = clavier.next().charAt(0);
    }while (c!='q');

  }
}
