package TP1;

import java.util.ArrayList;

/**
 * Interface Correcteur, les méthodes setListeCouleurs, getListeCouleurs et get NomFichier sont à implémenter.
 */
public interface Correcteur {

    /**
     * Initialise dans l'instance un ArrayList<Couleur> de toutes les couleurs de la photo.
     */
    void setListeCouleurs();

    /**
     * @return la liste de toutes les couleurs (Couleur) de l'attribut photo(BufferedImage).
     */
    ArrayList<Couleur> getListeCouleurs();

    /**
     * @return le String du chemin d'accès en entier, entré par l'utilisateur.
     */
    String getNomFichier();


}
