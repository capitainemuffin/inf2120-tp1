package TP1;

import java.util.Scanner;

/**
 * Ce programme demande le chemin d'accèes d'une photo,
 * la modifie avec 2 algorithmes et sauvegarde 2 nouvelles
 * photos dans le répertoire par défaut.
 *
 * @author Sofiane Selaoui, SELS28049204, selaoui.sofiane@courrier.uqam.ca
 */
public class Principal {

    /**
     * Lit une chaîne contenant le chemin d'accès de la photo à corriger.
     *
     * @return un String contenant le chemin d'accès de la photo à corriger.
     */
    private static String lireChaine() {

        Scanner sc = new Scanner(System.in);

        System.out.print(Messages.ENTRER_FICHIER);

        String nomFichier = sc.nextLine();

        sc.close();

        return nomFichier;

    }

    /**
     * La méthode main. Demande un chemin d'accès pour l'image à corriger. Crée un histogramme.
     * Corrige l'image de 2 façons différentes et sauvegarde 2 images.
     */
    public static void main(String[] args) {

        // Déclaration des variables

        String nomFichierEntrees;
        CorrecteurImage correcteur;
        Histogramme histogramme;
        nomFichierEntrees = lireChaine();
        AlgorithmeCLS imageCLS;
        AlgorithmeCLC imageCLC;

        // Initialisation du correcteur d'image

        correcteur = new CorrecteurImage(nomFichierEntrees);

        // Creation de l'histogramme des couleurs

        histogramme = new Histogramme(correcteur.getListeCouleurs());

        // Corriger l'image avec l'algorithme 1 et sauvegarder

        imageCLS = new AlgorithmeCLS(histogramme, correcteur.getNomFichier());
        imageCLS.corrigerImage();
        imageCLS.sauvegarder();

        // Corriger l'image avec l'algorithme 2 et sauvegarder

        imageCLC = new AlgorithmeCLC(histogramme, correcteur.getNomFichier());
        imageCLC.corrigerImage();
        imageCLC.sauvegarder();

    }
}
