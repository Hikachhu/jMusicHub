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

public class WriteVolatile{

	private TransformerFactory transformerFactory;
	private Transformer transformer;
	private DocumentBuilderFactory documentFactory;
	private DocumentBuilder documentBuilder;

  public WriteVolatile() {
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
}
