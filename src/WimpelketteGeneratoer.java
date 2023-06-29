
import java.util.ArrayList;
import java.util.List;

public class WimpelketteGeneratoer {
    private int maxQualitaet;
    private List<Wimpelkette> besteWimpelketten;

    public WimpelketteGeneratoer() {
        this.maxQualitaet = Integer.MIN_VALUE;
        this.besteWimpelketten = new ArrayList<>();
    }

    public void generiereOptimaleKette(List<Wimpel> wimpelListe, Wimpelkette aktuelleKette, int aktuellerIndex) {
        if (aktuellerIndex == wimpelListe.size()) {
            int[] qualitaet = aktuelleKette.berechneQualitaet();
            if (qualitaet[0] > maxQualitaet) {
                maxQualitaet = qualitaet[0];
                besteWimpelketten.clear();
                besteWimpelketten.add(new Wimpelkette(aktuelleKette.getWimpelListe())); // Kopie der aktuellen Kette hinzufügen
            } else if (qualitaet[0] == maxQualitaet) {
                besteWimpelketten.add(new Wimpelkette(aktuelleKette.getWimpelListe())); // Kopie der aktuellen Kette hinzufügen
            }
            return;
        }

        for (int i = 0; i < wimpelListe.size(); i++) {
            Wimpel wimpel = wimpelListe.get(i);
            if (wimpel.getAnzahl() > 0) {
                aktuelleKette.addWimpel(wimpel);
                wimpel.setAnzahl(wimpel.getAnzahl() - 1);
                generiereOptimaleKette(wimpelListe, aktuelleKette, aktuellerIndex + 1);
                aktuelleKette.removeLastWimpel(); // Letzten Wimpel entfernen
                wimpel.setAnzahl(wimpel.getAnzahl() + 1);
            }

        }
    }

    public List<Wimpelkette> getBesteWimpelketten() {
        return besteWimpelketten;
    }
}

