package TP1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Classe abstraite à hériter par tous les algorithmes de modification d'image.
 */
public abstract class Algorithme {

    private BufferedImage image;
    private Histogramme histogramme;
    private String nomFichier;

    /**
     * Constructeur, créer une instance Algorithme avec comme attribut l'image BufferedImage, l'histogramme de l'image
     * et le chemin d'accès du fichier.
     *
     * @param histogramme l'instance histogramme, utile pour obtenir les zones à zero dans l'image
     * @param nomFichier  le chemin d'accès de l'image
     */
    Algorithme(Histogramme histogramme, String nomFichier) {

        try {

            this.image = ImageIO.read(new File(nomFichier));

        } catch (IOException e) {

            System.err.println(Messages.FICHIER_INTROUVABLE);
            System.exit(-1);

        }
        this.histogramme = histogramme;
        this.nomFichier = nomFichier;
    }

    /**
     * Modifie l'attribut image (BufferedImage) de l'instance Algorithme.
     * Utilise la méthode algorithme.
     */
    void corrigerImage() {

        // Parcourir tous les points de l'image avec 2 boucles for imbriquées

        for (int x = 0; x < this.image.getWidth(); x++) {

            for (int y = 0; y < this.image.getHeight(); y++) {

                Couleur couleur = new Couleur(image.getRGB(x, y));

                // (1) obtenir l'entier couleur de l'instance Couleur (rouge, vert ou bleu)
                // (2) modifier l'entier couleur
                // (3) placer le nouvel entier dans l'instance Couleur

                int rouge = couleur.getRouge();
                rouge = algorithme(rouge, this.histogramme.getZonesRouges());
                couleur.setRouge(rouge);

                int vert = couleur.getVert();
                vert = algorithme(vert, this.histogramme.getZonesVertes());
                couleur.setVert(vert);

                int bleu = couleur.getBleu();
                bleu = algorithme(bleu, this.histogramme.getZonesBleues());
                couleur.setBleu(bleu);

                // (4) placer les nouvelles valeurs entières couleur dans l'image

                this.image.setRGB(x, y, couleur.getArgb());
            }
        }

    }

    /**
     * Prend un entier couleur, calcule la nouvelle couleur, retourne le nouvel entier couleur
     * Méthode à spécialiser dans les classes enfants de Algorithme.
     *
     * @param couleur l'entier de la couleur
     * @param zones   les zones à zéro/pas à zéro, déterminées dans TP1.Histogramme.
     * @return le nouvel entier couleur
     */
    abstract protected int algorithme(int couleur, ArrayList<int[]> zones);

    /**
     * Sauvegarde la nouvelle image dans le répertoire par défaut.
     * À spécialiser en fonction du nom et répertoire.
     */
    abstract protected void sauvegarder();

    /**
     * À utiliser par les sous-classes dans la méthode sauvegarder.
     *
     * @return l'attribut image (BufferedImage) corrigée.
     */
    BufferedImage getNouvelleImage() {
        return this.image;
    }

    /**
     * @return le nom du fichier image (ex : "C:/../image.jpg" -> retourne "image")
     */
    String getNomFichier() {
        String[] tabPhoto = this.nomFichier.split("/");
        String[] tabPhoto2 = tabPhoto[tabPhoto.length - 1].split("\\.");
        return tabPhoto2[0];
    }

}

