package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {



    public static void main(String[] args) {
	// write your code here
    }
    public static ArrayList<Grad> ucitajGradove(){
        ArrayList<Grad> g = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        Scanner ulaz;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("Datoteka brojevi.txt ne postoji ili se ne može otvoriti.");
            System.out.println("Greška: " + e);
            return null; // kraj programa
        }
        while(ulaz.hasNextLine()){
            temp.add(ulaz.nextLine());
        }
        for(int i = 0 ; i < temp.size(); i ++){
            Grad gr = new Grad();
            String [] t =temp.get(i).split(",");
            gr.setNaziv(t[0]);
            double [] d = new double[t.length -1];
            for(int j = 1 ; j<t.length ; j++){
                if(j==1000) break;
                try {
                    d[j - 1] = Double.valueOf(t[i]);
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            }
            gr.setTemperature(d);
            g.add(gr);
        }
        ulaz.close();
        return g;
    }

    static UN ucitajXml(String s, ArrayList<Grad> gradovi) {
        UN u = new UN();
        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File(s));
            Element korijen = xmldoc.getDocumentElement() ;
           u = funkcija(korijen);


        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
    static UN funkcija(Element element) {
        ArrayList<Drzava> drzave = new ArrayList<>();
        Drzava d = new Drzava();
        Grad g = new Grad();

        NodeList djeca = element.getChildNodes();
        for (int i = 0; i < djeca.getLength(); i++) {
            Node dijete = djeca.item(i);
            if (dijete instanceof Element) {
                Element e = (Element) dijete;
            }
        }

       UN u = new UN();

    return u;
    }
}
