package com.humanbooster.exercices;
import java.lang.Math;

public class Cercle implements Calculable, Dessinable{
    // - Implémenter les méthodes de calcul géométrique
    // - Implémenter les méthodes de dessin (représentation ASCII dans la console)
    // - Gérer la validation des données

    private double rayon;

    public Cercle(double rayon) throws Exception{
        if (rayon < 0) throw new IllegalArgumentException("Error: Argument <rayon> cannot be Lesser than Zero");
        this.rayon = rayon;
    }

    // GETTER
    public double getRayon(){
        return this.rayon;
    }

    // SETTER
    public void setRayon(double rayon){
        if (rayon < 0) throw new IllegalArgumentException("Error: Argument <rayon> cannot be Lesser than Zero");
        this.rayon = rayon;
    }


    // METHODS
    // - Les calculs nécessitent une précision de 0.001
    @Override
    public double calculerAire() throws Exception{
        double area = Math.PI * this.rayon * this.rayon;
        if (Double.isInfinite(area)) throw new Exception("Error: Double overflow");
        return area;
    }

    @Override
    public double calculerPerimetre() throws Exception{
        double perimeter = 2 * this.rayon * Math.PI;
        if (Double.isInfinite(perimeter)) throw new Exception("Error: Double overflow");
        return perimeter;
    }
}
