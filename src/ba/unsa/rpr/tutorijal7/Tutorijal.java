package ba.unsa.rpr.tutorijal7;

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
        int vel = 0;
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
}
