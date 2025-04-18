package com.humanbooster.exercices;

public interface Dessinable {
    // - Créer un rendu ASCII adapté aux dimensions
    // - Fournir une description claire et concise
    // - Gérer les cas limites (formes très grandes ou très petites)

    public void dessiner();
    public String obtenirDescription() throws Exception;
}
