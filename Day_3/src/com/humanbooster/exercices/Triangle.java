package com.humanbooster.exercices;

public class Triangle implements Calculable, Dessinable {
    // - Implémenter les méthodes de calcul géométrique
    // - Implémenter les méthodes de dessin (représentation ASCII dans la console)
    private double c1;
    private double c2;
    private double c3;
    private final int precision = (int) Math.pow(10, 5);
    private double[] angles;
    private String type;

    public Triangle(double c1, double c2, double c3) throws Exception {
        if (c1 <= 0)
            throw new IllegalArgumentException("Error: Argument <c1> must be Greater than Zero");
        if (c2 <= 0)
            throw new IllegalArgumentException("Error: Argument <c2> must be Greater than Zero");
        if (c3 <= 0)
            throw new IllegalArgumentException("Error: Argument <c3> must be Greater than Zero");
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.angles = this.getAngles();
        this.setType();
    }

    // GETTER
    public double getC1() {
        return this.c1;
    }

    public double getC2() {
        return this.c2;
    }

    public double getC3() {
        return this.c3;
    }

    // SETTER
    public void setC1(double c1) {
        if (c1 <= 0)
            throw new IllegalArgumentException("Error: Argument <c1> must be Greater than Zero");
        this.c1 = c1;
    }

    public void setC2(double c2) {
        if (c2 <= 0)
            throw new IllegalArgumentException("Error: Argument <c2> must be Greater than Zero");
        this.c2 = c2;
    }

    public void setC3(double c3) {
        if (c3 <= 0)
            throw new IllegalArgumentException("Error: Argument <c3> must be Greater than Zero");
        this.c3 = c3;
    }

    // METHODS
    // - Les calculs nécessitent une précision de 0.001
    @Override
    public double calculerAire() throws Exception {
        double area = 0;
        if (Double.isInfinite(area))
            throw new Exception("Error: Double overflow");
        return area;
    }

    @Override
    public double calculerPerimetre() throws Exception {
        double perimeter = c1 + c2 + c3;
        if (Double.isInfinite(perimeter))
            throw new Exception("Error: Double overflow");
        return perimeter;
    }

    @Override
    public void dessiner() {
        System.out.println("Not possible in ASCII representation");
    }

    public double cosLaw(double a, double b, double c) {
        double cosC = ((a * a + b * b) - (c * c)) / (2 * a * b);
        return Math.toDegrees(Math.acos(cosC));
    }

    public double[] getAngles() {
        double[] angles = new double[3];
        angles[0] = (Math.round(this.cosLaw(this.c2, this.c3, this.c1) * this.precision)) / this.precision;
        angles[1] = (Math.round(this.cosLaw(this.c1, this.c3, this.c2) * this.precision)) / this.precision;
        angles[2] = (Math.round(this.cosLaw(this.c1, this.c2, this.c3) * this.precision)) / this.precision;
        return angles;
    }

    public boolean isRectangle() {
        for(double angle : this.angles){
            if (angle == 90) return true;
        }
        return false;
    }

    public boolean isEquilateral() {
        if ((this.c1 == this.c2) && (this.c1 == this.c3)) return true;
        return false;
    }

    public boolean isIsocele() {
        if ((this.c1 == this.c2) && !(this.c1 == this.c3)
        || (this.c1 == this.c3) && !(this.c1 == this.c2)
        || (this.c2 == this.c3) && !(this.c2 == this.c1)) return true;
        return false;
    }

    public void setType(){
        if (!(this.isRectangle()) && !(this.isIsocele()) && !(this.isEquilateral())) this.type = "Quelconque";
        else this.type = "";
        if (this.isRectangle()) this.type += " Rectangle";
        if (this.isIsocele()) this.type += " Isocele";
        if (this.isEquilateral()) this.type += " Equilateral";
        this.type = this.type.trim();
    }

    @Override
    public String obtenirDescription() throws Exception {
        return ("Triangle:\nCote 1: " + this.c1 + "\nCote 2: " + this.c2 + "\nCote 3: " + this.c3 +
                "\nPerimetre: " + this.calculerPerimetre() + "\nAire: " + this.calculerAire() +
                "\nAngle A: " + this.angles[0] + "\nAngle B: " + this.angles[1] + "\nAngle C: " + this.angles[2] +
                "\nIl s'agit d'un Triangle " + this.type);
    }
}
