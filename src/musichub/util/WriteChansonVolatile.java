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

public class WriteChansonVolatile{

	private TransformerFactory transformerFactory;
	private Transformer transformer;
	private DocumentBuilderFactory documentFactory;
	private DocumentBuilder documentBuilder;

	public WriteChansonVolatile() {
		try {
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			documentFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentFactory.newDocumentBuilder();
		} catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
		}

	public void createXMLFile(Document document, String filePath){
		try {
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File(filePath));

		transformer.transform(domSource, streamResult);

		} catch (TransformerException tfe) {
						tfe.printStackTrace();
		}
		System.out.println("Done creating XML File");
	}

	/**
	* La methode qui crée le document en memoire
	* @return le document créé
	*/
	public Document createXMLDocument(){
		return documentBuilder.newDocument();
	}

	/**
	* La methode qui lit un fichier XML et le transforme en liste de noeuds en mémoire
	* @param filePath le chemin (répértoire et nom) du fichier XML à lire
	* @return la liste des noeuds lus
	*/
	public NodeList parseXMLFile (String filePath){
		NodeList elementNodes = null;
		try {
			Document document= documentBuilder.parse(new File(filePath));
			Element root = document.getDocumentElement();

			elementNodes = root.getChildNodes();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return elementNodes;
	}

	/**
	* Methode pour démontrer la lecture d'un fichier XML qui contient plusieurs éléments
	*/
	public ChansonVolatile readXML(String Fichier) {
		ChansonVolatile nouvelle = new ChansonVolatile();
		NodeList nodes = this.parseXMLFile(Fichier);
		if (nodes != null){
			for (int i = 0; i<nodes.getLength(); i++) {
				if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
					Element currentElement = (Element) nodes.item(i);
					if (currentElement.getNodeName().equals("Chanson")) 	{
						try {
							String Titre = currentElement.getElementsByTagName("Titre").item(0).getTextContent();
							int Duree = Integer.parseInt(currentElement.getElementsByTagName("Duree").item(0).getTextContent());
							int ID = Integer.parseInt(currentElement.getElementsByTagName("ID").item(0).getTextContent());
							String Artiste = currentElement.getElementsByTagName("Artiste").item(0).getTextContent();
							String Contenu = currentElement.getElementsByTagName("Contenu").item(0).getTextContent();
							int Genre = Integer.parseInt(currentElement.getElementsByTagName("Genre").item(0).getTextContent());
							Chanson lu = new Chanson(Titre,Duree,ID,Artiste,Contenu,Genre);
							nouvelle.add(lu);
						} catch (Exception ex) {
							System.out.println("Something is wrong with the XML client element");
						}
					}
				}
			}
		}
		return nouvelle;
	}

	/**
	* Methode pour démontrer l'écriture d'un fichier XML avec un seul élément
	*/
	public void writeXML(String Fichier,ChansonVolatile EnsembleAecrire) {
		Document document = this.createXMLDocument();
		if (document == null) return;

		// create root element
		Element root = document.createElement("Chansons");
		document.appendChild(root);

		// String Titre,int Duree,int ID,String Artiste,String Contenu,int genre
		//save one "client" element; create a loop to save more elements!!
		for (Chanson Aecrire : EnsembleAecrire.getEnsemble() ) {

				Element client = document.createElement("Chanson");
				// clientUUID element
					Element Titre = document.createElement("Titre");
					Titre.appendChild(document.createTextNode(Aecrire.getTitre()));
					client.appendChild(Titre);

					// firstName element
					Element Duree = document.createElement("Duree");
					Duree.appendChild(document.createTextNode(Integer.toString(Aecrire.getDureeSec())));
					client.appendChild(Duree);

					// firstName element
					Element ID = document.createElement("ID");
					ID.appendChild(document.createTextNode(Integer.toString(Aecrire.getID())));
					client.appendChild(ID);

					Element Artiste = document.createElement("Artiste");
					Artiste.appendChild(document.createTextNode(Aecrire.getArtiste()));
					client.appendChild(Artiste);

					Element Contenu = document.createElement("Contenu");
					Contenu.appendChild(document.createTextNode(Aecrire.getContenu()));
					client.appendChild(Contenu);

					Element Genre = document.createElement("Genre");
					Genre.appendChild(document.createTextNode(Integer.toString(Aecrire.getGenreNumber())));
					client.appendChild(Genre);

			root.appendChild(client);
		}
		this.createXMLFile(document, Fichier);
	}

}
