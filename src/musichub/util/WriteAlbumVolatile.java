package musichub.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

import org.w3c.dom.*;
import java.io.IOException;
import java.io.File;
import java.util.UUID;

import musichub.util.*;
import musichub.business.*;

public class WriteAlbumVolatile extends WriteVolatile{

	public AlbumVolatile readXML(String Fichier) {
		AlbumVolatile nouvelle = new AlbumVolatile();

		NodeList nodesAlbum = this.parseXMLFile(Fichier);//

		if (nodesAlbum != null){

			for (int i = 0; i<nodesAlbum.getLength(); i++) {
				if (nodesAlbum.item(i).getNodeType() == Node.ELEMENT_NODE)   {
					Node currentElementNode = nodesAlbum.item(i);// album
					if (currentElementNode.getNodeName().equals("Album")) 	{
						Element currentElement= (Element) currentElementNode;
						try {
							String Titre = 								 currentElement.getElementsByTagName("Titre").item(0).getTextContent();
							int Duree = 	Integer.parseInt(currentElement.getElementsByTagName("Duree").item(0).getTextContent());
							int ID = 			Integer.parseInt(currentElement.getElementsByTagName("ID").item(0).getTextContent());
							int DateSortie = 			Integer.parseInt(currentElement.getElementsByTagName("DateSortie").item(0).getTextContent());
							String Artiste = 							 currentElement.getElementsByTagName("Artiste").item(0).getTextContent();
							Album AlbumLu = new Album(Titre,Duree,ID,Artiste,DateSortie);
							nouvelle.add(AlbumLu);

							Element ListeChanson1 =(Element) (currentElement.getElementsByTagName("ListeChanson").item(0));
							NodeList ListeChanson =(NodeList) (ListeChanson1.getChildNodes());
							//Jusqua la ca fonctionne

							for (int j = 0; j<ListeChanson.getLength(); j++) {
								if (ListeChanson.item(j).getNodeType() == Node.ELEMENT_NODE)   {
									Element ChansonCurrent = (Element) ListeChanson.item(j);
										if (ChansonCurrent.getNodeName().equals("Chanson")) 	{
											try {
												String Titre1 = 								 ChansonCurrent.getElementsByTagName("Titre").item(0).getTextContent();
												int Duree1 = 	Integer.parseInt(ChansonCurrent.getElementsByTagName("Duree").item(0).getTextContent());
												int ID1 = 			Integer.parseInt(ChansonCurrent.getElementsByTagName("ID").item(0).getTextContent());
												String Artiste1 = 							 ChansonCurrent.getElementsByTagName("Artiste").item(0).getTextContent();
												String Contenu = 							 ChansonCurrent.getElementsByTagName("Contenu").item(0).getTextContent();
												int Genre = 	Integer.parseInt(ChansonCurrent.getElementsByTagName("Genre").item(0).getTextContent());
												Chanson lu = new Chanson(Titre1,Duree1,ID1,Artiste1,Contenu,Genre);
												nouvelle.add(i,lu);
											} catch (Exception ex) {
												System.out.println("Probleme chanson");
											}
										}
									}
							}

						} catch (Exception ex) {
							System.out.println("Probleme Album");
						}
					}
				}
			}
		}
		return nouvelle;
	}

	public void writeXML(String Fichier,AlbumVolatile EnsembleAecrire) {
		Document document = this.createXMLDocument();
		if (document == null) return;

		Element root = document.createElement("ListeAlbums");
		document.appendChild(root);

		for (Album AlbumEcrire : EnsembleAecrire.getEnsemble() ) {
			root.appendChild(AlbumEcrire.getElement(document));
		}
		this.createXMLFile(document, Fichier);
	}

}
