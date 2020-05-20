package TP1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * La classe pour créer un objet de type CorrecteurImage, implémente Correcteur et donc les méthodes
 * setListeCouleurs, getListeCouleurs et getNomFichier.
 */
public class CorrecteurImage implements Correcteur {

    private String nomFichier;
    private BufferedImage image;
    private ArrayList<Couleur> listeCouleurs;

    /**
     * Constructeur, contient une instance BufferedImage et le String du chemin du fichier.
     *
     * @param nomFichier le chemin d'accès spécifié par l'utilisateur
     */
    CorrecteurImage(String nomFichier) {

        try {

            this.image = ImageIO.read(new File(nomFichier));

        } catch (IOException e) {

            System.err.println(Messages.FICHIER_INTROUVABLE);
            System.exit(-1);

        }

        this.nomFichier = nomFichier;
        setListeCouleurs();

    }

    /**
     * Initialise dans l'instance un ArrayList<Couleur> de toutes les couleurs de la photo.
     */
    public void setListeCouleurs() {

        this.listeCouleurs = new ArrayList<>();

        try {

            for (int x = 0; x < this.image.getWidth(); x++) {

                for (int y = 0; y < this.image.getHeight(); y++) {

                    Couleur couleur = new Couleur(this.image.getRGB(x, y));
                    this.listeCouleurs.add(couleur);

                }
            }

        } catch (NullPointerException e) {

            System.err.println(Messages.FICHIER_INVALIDE);
            System.exit(-1);

        }

    }

    /**
     * Générer une liste contenant toutes les couleurs de l'instance BufferedImage.
     *
     * @return ArrayList<Couleur> une liste d'instances Couleur de l'image.
     */
    public ArrayList<Couleur> getListeCouleurs() {

        return this.listeCouleurs;
    }

    /**
     * @return le String du chemin d'accès en entier, entré par l'utilisateur.
     */
    public String getNomFichier() {

        return nomFichier;

    }

}

