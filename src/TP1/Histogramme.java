package TP1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe histogramme qui construit 3 histogrammes des couleurs Rouge, Vert, Bleu de l'image BufferedImage.
 * Ainsi que 3 listes des zones pas à zéros de ces histogrammes.
 */
public class Histogramme {

    private Map<Integer, Integer> histogrammeRouge = new HashMap<>();
    private Map<Integer, Integer> histogrammeVert = new HashMap<>();
    private Map<Integer, Integer> histogrammeBleu = new HashMap<>();
    private ArrayList<int[]> zonesRouges = new ArrayList<>();
    private ArrayList<int[]> zonesVertes = new ArrayList<>();
    private ArrayList<int[]> zonesBleues = new ArrayList<>();

    /**
     * Constructeur, créer instance Histogramme contenant les 3 histogrammes (rouge, vert, bleu) et leur zones à zéro respectives.
     *
     * @param listeCouleurs la liste de toutes les couleurs (Couleur) de l'attribut BufferedImage de l'instance de CorrecteurImage.
     */
    public Histogramme(ArrayList<Couleur> listeCouleurs) {

        for (int i = 0; i <= 255; i++) {

            this.histogrammeRouge.put(i, 0);
            this.histogrammeVert.put(i, 0);
            this.histogrammeBleu.put(i, 0);

        }

        for (Couleur couleur : listeCouleurs) {

            this.histogrammeRouge.replace(couleur.getRouge(), this.histogrammeRouge.get(couleur.getRouge()) + 1);
            this.histogrammeVert.replace(couleur.getVert(), this.histogrammeVert.get(couleur.getVert()) + 1);
            this.histogrammeBleu.replace(couleur.getBleu(), this.histogrammeBleu.get(couleur.getBleu()) + 1);

        }

        setZonesRouges();
        setZonesVertes();
        setZonesBleues();

    }

    /**
     * Initialise l'attribut zoneRouge de l'instance (ArrayList(int[]).
     * Une liste qui contient les zones pas à Zéro dans l'histogramme Rouge.
     */
    private void setZonesRouges() {

        int index = 0;
        boolean debutDeZone = false;

        for (Integer key : this.histogrammeRouge.keySet()) {


            if (this.histogrammeRouge.get(key) != 0) {

                if (!debutDeZone) {

                    debutDeZone = true;
                    int[] zone = {key, 0};
                    this.zonesRouges.add(zone);
                }

                if (key == 255) {
                    this.zonesRouges.get(index)[1] = key;
                }

            } else {

                if (debutDeZone) {

                    debutDeZone = false;
                    this.zonesRouges.get(index)[1] = key - 1;
                    index++;

                }
            }

        }

    }

    /**
     * Initialise l'attribut ZonesVertes de l'instance (ArrayList(int[]).
     * Une liste qui contient les zones pas à Zéro dans l'histogramme Vert.
     */
    private void setZonesVertes() {

        int index = 0;
        boolean debutDeZone = false;

        for (Integer key : this.histogrammeVert.keySet()) {

            if (this.histogrammeVert.get(key) != 0) {

                if (!debutDeZone) {

                    debutDeZone = true;
                    int[] zone = {key, 0};
                    this.zonesVertes.add(zone);

                }

                if (key == 255) {
                    this.zonesVertes.get(index)[1] = key;
                }

            } else {

                if (debutDeZone) {

                    debutDeZone = false;
                    this.zonesVertes.get(index)[1] = key - 1;
                    index++;

                }
            }

        }

    }

    /**
     * Initialise l'attribut zonesBleues de l'instance (ArrayList(int[]).
     * Une liste qui contient les zones pas à Zéro dans l'histogramme Bleu.
     */
    private void setZonesBleues() {

        int index = 0;
        boolean debutDeZone = false;

        for (Integer key : this.histogrammeBleu.keySet()) {


            if (this.histogrammeBleu.get(key) != 0) {

                if (!debutDeZone) {

                    debutDeZone = true;
                    int[] zone = {key, 0};
                    this.zonesBleues.add(zone);

                }

                if (key == 255) {
                    this.zonesBleues.get(index)[1] = key;
                }

            } else {

                if (debutDeZone) {

                    debutDeZone = false;
                    this.zonesBleues.get(index)[1] = key - 1;
                    index++;

                }
            }

        }

    }

    /**
     * @return les zones pas à Zéro de l'histogramme Rouge.
     */
    ArrayList<int[]> getZonesRouges() {

        return zonesRouges;
    }

    /**
     * @return les zones pas à Zéro de l'histogramme Vert.
     */
    ArrayList<int[]> getZonesVertes() {

        return zonesVertes;
    }

    /**
     * @return les zones pas à Zéro de l'histogramme Bleu.
     */
    ArrayList<int[]> getZonesBleues() {

        return zonesBleues;
    }

}
