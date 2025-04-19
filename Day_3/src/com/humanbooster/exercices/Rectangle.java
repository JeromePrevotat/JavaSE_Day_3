package com.humanbooster.exercices;

public class Rectangle implements Calculable, Dessinable{    
    private double c1;
    private double c2;

    public Rectangle (double c1, double c2) throws Exception{
        if (c1 <= 0) throw new IllegalArgumentException("Error: Argument <c1> must be Greater than Zero");
        if (c2 <= 0) throw new IllegalArgumentException("Error: Argument <c2> must be Greater than Zero");
        this.c1 = c1;
        this.c2 = c2;
    }

    // GETTER
    public double getC1(){
        return this.c1;
    }

    public double getC2(){
        return this.c2;
    }

    // SETTER
    public void setC1(double c1){
        if (c1 <= 0) throw new IllegalArgumentException("Error: Argument <c1> must be Greater than Zero");
        this.c1 = c1;
    }

    public void setC2(double c2){
        if (c2 <= 0) throw new IllegalArgumentException("Error: Argument <c2> must be Greater than Zero");
        this.c2 = c2;
    }

    // METHODS
    // - Les calculs nécessitent une précision de 0.001
    @Override
    public double calculerAire() throws Exception{
        double area = c1 * c2;
        if (Double.isInfinite(area)) throw new Exception("Error: Double overflow");
        return area;
    }

    @Override
    public double calculerPerimetre() throws Exception{
        double perimeter = c1 * 2 + c2 * 2;
        if (Double.isInfinite(perimeter)) throw new Exception("Error: Double overflow");
        return perimeter;
    }

    @Override
    public void dessiner(){
        int i = 0;
        int max = (int) Math.ceil(Math.max(this.c1, this.c2));
        while (i < (int) (this.c1 * this.c2)) {
            if (i % max == 0) System.out.print("\n");
            else System.out.print(" * ");
            i++;
        }
    }

    @Override
    public String obtenirDescription() throws Exception{
        double longueur;
        double largeur;

        if (this.c1 > this.c2) {
            longueur = this.c1;
            largeur = this.c2;    
        }
        else{
            longueur = this.c2;
            largeur = this.c1;
        }
        return ("Rectangle:\nLongueur: " + longueur + "\nLargeur: " + largeur +
        "\nPerimetre: " + this.calculerPerimetre() + "\nAire: " + this.calculerAire());
    }
}
