package TP1;

/**
 * Enumeration des messages qui peuvent s'afficher dans la console lors de l'exécution.
 */
public enum Messages {

    FICHIER_INTROUVABLE("Le fichier sélectionné est introuvable."),
    FICHIER_CLS_ENREGISTRE("L'image CLS a été enregistrée."),
    FICHIER_CLC_ENREGISTRE("L'image CLC a été enregistrée."),
    FICHIER_INVALIDE("Le fichier n'est pas une image valide."),
    ENTRER_FICHIER("Svp entrez le chemin de l'image à corriger: "),
    ERREUR_ENREGISTREMENT("Erreur lors de l'enregistrement des images corrigées.");

    String message;

    /**
     * Constructeur
     * @param message
     */
    Messages(String message) {

        this.message = message;

    }

    /**
     * @return le String de l'objet à afficher
     */
    @Override
    public String toString() {
        return this.message;
    }
}

