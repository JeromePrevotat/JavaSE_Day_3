package com.humanbooster.exercices;

public class Voiture extends Vehicule{
    private boolean started;
    private int actualSpeed;
    private int nbPorte;
    private int nbRoue;

    public Voiture(String marque, String modele, int vitesseMax, int nbPorte, int nbRoue, int actualSpeed) throws Exception{
        super(marque, modele, vitesseMax);
        if (nbPorte <= 0) throw new IllegalArgumentException("Error: Argument <nbPorte> cannot be Lesser than or Equal to Zero");
        if (nbRoue < 4) throw new IllegalArgumentException("Error: Argument <nbRoue> cannot be Lesser than 4");
        if (actualSpeed < 0) throw new IllegalArgumentException("Error: Argument <speed> cannot be Lesser than Zero");
        this.nbPorte = nbPorte;
        this.nbRoue = nbRoue;
        this.actualSpeed = actualSpeed;
    }

    // GETTER
    public int getNbPorte(){
        return this.nbPorte;
    }
    
    public int getNbRoue(){
        return this.nbRoue;
    }

    public int getActualSpeed(){
        return this.actualSpeed;
    }

    public boolean getStarted(){
        return this.started;
    }

    // SETTER
    public void setNbPorte(int nbPorte){
        if (nbPorte <= 0) throw new IllegalArgumentException("Error: Argument <nbPorte> cannot be Lesser than or Equal to Zero");
        this.nbPorte = nbPorte;
    }
    
    public void setNbRoue(int nbRoue){
        if (nbRoue < 4) throw new IllegalArgumentException("Error: Argument <nbRoue> cannot be Lesser than 4");
        this.nbRoue = nbRoue;
    }

    public void setStarted(boolean b){
        this.started = b;
    }

    public void setActualSpeed(int speed){
        if (speed < 0) throw new IllegalArgumentException("Error: Argument <speed> cannot be Lesser than Zero");
        this.actualSpeed = speed;
    }

    @Override
    public void freiner(){
        if (this.actualSpeed > 0){
            System.err.println("Freinage : " + this.actualSpeed + " / " + super.getVitesseMax());
            this.setActualSpeed(this.actualSpeed - 1);
        }
        if (this.actualSpeed == 0) System.out.println("Full Stop !");
    }

    @Override
    public void accelerer(){
        while (this.started && this.actualSpeed < super.getVitesseMax()){
            System.err.println("Acceleration : " + this.actualSpeed + " / " + super.getVitesseMax());
            this.setActualSpeed(this.actualSpeed + 1);
        }
        if (this.actualSpeed == super.getVitesseMax()) System.out.println("Max Speed Reached !");
        if (!this.started) System.out.println("Start up the Engine !");
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
            "Vitesse Actuelle: " + this.actualSpeed + "\n" +
            "VitesseMax: " + this.getVitesseMax() + "\n" +
            "Nombre de Portes: " + nbPorte + "\n" +
            "Nombre de Roues: " + nbRoue);
    }
}
