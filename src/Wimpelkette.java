
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Wimpelkette {
    private List<Wimpel> wimpelListe;

    public Wimpelkette(List<Wimpel> wimpelListe) {
        this.wimpelListe = new ArrayList<>(wimpelListe);
    }

    public void addWimpel(Wimpel w) {
        int anzahl = w.getAnzahl();
        String farbe = w.getFarbe();
        for (int i = 0; i < anzahl; i++) {
            this.wimpelListe.add(new Wimpel(farbe, 1));
        }

    }

    public void removeLastWimpel() {
        if (!wimpelListe.isEmpty()) {
            wimpelListe.remove(wimpelListe.size() - 1);
        }
    }
    public List<Wimpel> getWimpelListe() {
        return wimpelListe;
    }

    public int[] berechneQualitaet() {
        int minDistance = Integer.MAX_VALUE;
        int frequencyOfMinDistance = 0;
        Map<String, Integer> lastPositionOfColor = new HashMap<>();

        for (int i = 0; i < wimpelListe.size(); i++) {
            String color = wimpelListe.get(i).getFarbe();
            if (lastPositionOfColor.containsKey(color)) {
                int distance = i - lastPositionOfColor.get(color);
                if (distance < minDistance) {
                    minDistance = distance;
                    frequencyOfMinDistance = 1;
                } else if (distance == minDistance) {
                    frequencyOfMinDistance++;
                }
            }
            lastPositionOfColor.put(color, i);
        }

        return new int[]{minDistance, frequencyOfMinDistance};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Wimpel wimpel : wimpelListe) {
            sb.append(wimpel.getFarbe());
        }
        return sb.toString();
    }
}
