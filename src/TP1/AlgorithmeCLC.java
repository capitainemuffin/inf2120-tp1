package TP1;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe pour l'algorithme 2, sous-classe de Algorithme
 */
public class AlgorithmeCLC extends Algorithme {

    /**
     * Constructeur de AlgorithmeCLC
     *
     * @param histogramme l'instance de Histogramme, pour obtenir les zones à zéro.
     * @param nomFichier  le chemin d'accès de l'image.
     */
    AlgorithmeCLC(Histogramme histogramme, String nomFichier) {

        super(histogramme, nomFichier);

    }

    /**
     * Prend un entier couleur, calcule la nouvelle couleur, retourne le nouvel entier couleur
     *
     * @param couleur l'entier de la couleur
     * @param zones   les zones à zéro/pas à zéro, déterminées dans Histogramme.
     * @return le nouvel entier couleur
     */
    @Override
    public int algorithme(int couleur, ArrayList<int[]> zones) {

        // Trouver les milieux de chaque zone

        ArrayList<Integer> milieux = new ArrayList<>();
        int resultat = couleur;

        // première zone -> milieu = 0

        milieux.add(0);

        // toutes les autres zones : milieu = (fin de zone précédente + début de zone courante)/2

        for (int i = 1; i < zones.size(); i++) {

            int nominateur = zones.get(i - 1)[1] + zones.get(i)[0];
            int milieu = nominateur / 2;
            milieux.add(milieu);

        }

        // i = k + 1 -> mileu = 255

        milieux.add(255);

        // trouver la couleur courante appartient à quelle zone

        for (int i = 0; i < zones.size(); i++) {

            if (zones.get(i)[0] <= couleur && couleur <= zones.get(i)[1]) {

                // nominateur = (milieu de la zone suivante - milieu de la zone courante + 1) / (couleur - début de zone courante)

                int nominateur = (milieux.get(i + 1) - milieux.get(i) + 1) * (couleur - zones.get(i)[0]);

                // dénominateur = fin de zone courante - début de zone courante + 1

                int denominateur = zones.get(i)[1] - zones.get(i)[0] + 1;

                // nouvelle valeur couleur = milieu de zone courante + (nominateur/denominateur)

                resultat = milieux.get(i) + (nominateur / denominateur);

            }
        }

        return resultat;
    }

    /**
     * Sauvegarde l'image clc dans le répertoire par défaut.
     * Ajoute "clc" au nom de l'image. (ex : "image.jpg" -> "imageclc.jpg")
     */
    @Override
    protected void sauvegarder() {

        try {

            String nomPhotoCLS = this.getNomFichier() + "clc.jpg";
            ImageIO.write(this.getNouvelleImage(), "jpg", new File(nomPhotoCLS));
            System.out.println(Messages.FICHIER_CLC_ENREGISTRE);

        } catch (IOException e) {

            System.err.println(Messages.ERREUR_ENREGISTREMENT);

        }

    }
}
