

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Wimpel {
    private String farbe;
    private int anzahl;
      public int position ;
//Wimpel wimpel = new Wimpel(farbe, anzahl, wimpelListe.size() + 1);
    public Wimpel(String farbe, int anzahl) {
        this.farbe = farbe;
        this.anzahl = anzahl;

    }

    public String getFarbe() {
        return farbe;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    public void setFarbe(String farbe){
        this.farbe=farbe;
    }
}


