
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        List<Wimpel> wimpelListe = new ArrayList<>();



        wimpelListe.add(new Wimpel("s", 2));
        wimpelListe.add(new Wimpel("w", 4));
        wimpelListe.add(new Wimpel("g", 2));
        wimpelListe.add(new Wimpel("b", 3));
        wimpelListe.add(new Wimpel("r", 4));








        WimpelketteGeneratoer generator = new WimpelketteGeneratoer();
        Wimpelkette aktuelleKette = new Wimpelkette(wimpelListe);
      //  Wimpelkette andereKette = new Wimpelkette(wimpelListe);

        generator.generiereOptimaleKette(wimpelListe, aktuelleKette, 0);
        List<Wimpelkette> besteWimpelketten = generator.getBesteWimpelketten();

        System.out.println("Beste Wimpelketten:");
        for (int i = 0; i < besteWimpelketten.size(); i++) {
            System.out.println("Kette " + (i + 1) + ": " + besteWimpelketten.get(i).toString());
        }

        System.out.println("Anzahl der besten Lösungen: " + besteWimpelketten.size());


    }
}

