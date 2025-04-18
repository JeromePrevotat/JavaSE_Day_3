package com.humanbooster.exercices;

public class Moto extends Vehicule{
    private boolean started;
    private int nbPlace;
    private int nbRoue;

    public Moto(String marque, String modele, int vitesseMax, int nbPlace, int nbRoue) throws Exception{
        super(marque, modele, vitesseMax);
        if (nbPlace <= 0) throw new IllegalArgumentException("Error: Argument <nbPlace> cannot be Lesser than or Equal to Zero");
        if (nbPlace > 3) throw new IllegalArgumentException("Error: Argument <nbPlace> cannot be Greater than 3");
        if (nbRoue < 2) throw new IllegalArgumentException("Error: Argument <nbRoue> cannot be Lesser than 2");
        this.nbPlace = nbPlace;
        this.nbRoue = nbRoue;
    }

    // GETTER
    public int getNbPlace(){
        return this.nbPlace;
    }

    public int getNbRoue(){
        return this.nbRoue;
    }

    public boolean getStarted(){
        return this.started;
    }

    // SETTER
    public void setNbPlace(int nbPlace){
        if (nbPlace <= 0) throw new IllegalArgumentException("Error: Argument <nbPlace> cannot be Negative or Equal to Zero");
        this.nbPlace = nbPlace;
    }

    public void setNbRoue(int nbRoue){
        if (nbRoue < 2) throw new IllegalArgumentException("Error: Argument <nbRoue> cannot be Lesser than 2");
        this.nbRoue = nbRoue;
    }

    public void setStarted(boolean b){
        this.started = b;
    }

    @Override
    public void freiner(){
        System.out.println("Freinage");
    }
    @Override
    public void accelerer(){
        System.out.println("Acceleration");
    }
    @Override
    public void demarrer(){
        if (!started){
            started = true;
            System.out.println("Starting");
        }
        else System.out.println("Already running");
    }

    @Override
    public String toString(){
        return ("Marque: " + this.getMarque() + "\n" +
            "Modele: " + this.getModele() + "\n" +
            "VitesseMax: " + this.getVitesseMax() + "\n" +
            "Nombre de Portes: " + nbPlace + "\n" +
            "Nombre de Roues: " + nbRoue);
    }
}
