package TP1;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe pour l'algorithme 1, sous-classe de Algorithme.
 */
public class AlgorithmeCLS extends Algorithme {

    /**
     * Constructeur de AlgorithmeCLS
     *
     * @param histogramme l'instance de Histogramme, pour obtenir les zones à zéro.
     * @param nomFichier  le chemin d'accès de l'image.
     */
    AlgorithmeCLS(Histogramme histogramme, String nomFichier) {

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
    protected int algorithme(int couleur, ArrayList<int[]> zones) {

        // nouvelle couleur = (257 * début de la première zone) / (fin de la derniere zone - debut de la premiere zone + 1)

        int debutPremiereZone = zones.get(0)[0];
        int finDerniereZone = zones.get(zones.size() - 1)[1];
        int nominateur = 256 * (couleur - debutPremiereZone);
        int denominateur = finDerniereZone - debutPremiereZone + 1;

        return nominateur / denominateur;
    }

    /**
     * Sauvegarde l'image cls dans le répertoire par défaut.
     * Ajoute "cls" au nom de l'image. (ex : "image.jpg" -> "imagecls.jpg")
     */
    @Override
    protected void sauvegarder() {

        try {

            String nomPhotoCLS = this.getNomFichier() + "cls.jpg";
            ImageIO.write(this.getNouvelleImage(), "jpg", new File(nomPhotoCLS));
            System.out.println(Messages.FICHIER_CLS_ENREGISTRE);

        } catch (IOException e) {

            System.err.println(Messages.ERREUR_ENREGISTREMENT);

        }

    }
}
