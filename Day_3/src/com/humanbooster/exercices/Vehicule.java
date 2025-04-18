package com.humanbooster.exercices;

public abstract class Vehicule {
    private String marque;
    private String modele;
    private int vitesseMax;

    public Vehicule (String marque, String modele, int vitesseMax) throws Exception{
        if (marque == null ||marque.trim().isEmpty()) throw new IllegalArgumentException("Error: Argument <marque> cannot be null or Empty");
        if (modele == null ||modele.trim().isEmpty()) throw new IllegalArgumentException("Error: Argument <modele> cannot be null or Empty");
        // Lesser than Zero to allow Zero as default value
        if (vitesseMax < 0) throw new IllegalArgumentException("Error: Argument <vitesseMax> cannot be Lesser than Zero");
        this.marque = marque;
        this.modele = modele;
        this.vitesseMax = vitesseMax;
    }

    // Getter
    public String getMarque(){
        return this.marque;
    }
    public String getModele(){
        return this.modele;
    }
    public int getVitesseMax(){
        return this.vitesseMax;
    }

    // SETTER
    public void setMarque(String marque){
        if (marque == null ||marque.trim().isEmpty()) throw new IllegalArgumentException("Error: Argument <marque> cannot be null or Empty");
        this.marque = marque;
    }
    public void setModele(String modele){
        if (modele == null ||modele.trim().isEmpty()) throw new IllegalArgumentException("Error: Argument <modele> cannot be null or Empty");
        this.modele = modele;
    }
    public void setVitesseMax(int vitesseMax){
        // Lesser than or Equal to Zero as of now the maxSpeed is known
        if (vitesseMax <= 0) throw new IllegalArgumentException("Error: Argument <vitesseMax> cannot be Lesser than or Equal to Zero");
        this.vitesseMax = vitesseMax;
    }

    public abstract void demarrer();
    public abstract void accelerer();
    public abstract void freiner();

    @Override
    public String toString(){
        return ("Marque: " + this.marque + "\n" +
            "Modele: " + this.modele + "\n" +
            "VitesseMax: " + this.vitesseMax + "\n");
    }
}
