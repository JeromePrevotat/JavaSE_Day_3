package com.humanbooster.exercices;

public class Triangle implements Calculable, Dessinable {
    // - Implémenter les méthodes de calcul géométrique
    // - Implémenter les méthodes de dessin (représentation ASCII dans la console)
    private double c1;
    private double c2;
    private double c3;
    private final int precision = (int) Math.pow(10, 5);
    private double[] angles = new double[3];
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
        this.setAngles();
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

    public double[] getAngles(){
        return this.angles;
    }

    public String getType(){
        return this.type;
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

    public void setAngles() {
        this.angles[0] = (Math.round(this.cosLaw(this.c2, this.c3, this.c1) * this.precision)) / this.precision;
        this.angles[1] = (Math.round(this.cosLaw(this.c1, this.c3, this.c2) * this.precision)) / this.precision;
        this.angles[2] = (Math.round(this.cosLaw(this.c1, this.c2, this.c3) * this.precision)) / this.precision;
    }
    
    public void setType(){
        if (!(this.isRectangle()) && !(this.isIsocele()) && !(this.isEquilateral())) this.type = "Quelconque";
        else this.type = "";
        if (this.isRectangle()) this.type += " Rectangle";
        if (this.isIsocele()) this.type += " Isocele";
        if (this.isEquilateral()) this.type += " Equilateral";
        this.type = this.type.trim();
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
        // System.out.println("Not possible in ASCII representation");
        if (this.type.equals("Equilateral")) this.dessinerEquilateral();
        if (this.type.equals("Isocele")) this.dessinerIsocele();
        
    }

    public void dessinerEquilateral(){
        int i = 0;
        int h = 0;
        System.out.println("It is mathematicaly impossible to represent an Equilateral Triangle in ASCII as all angles must be equal to 60 degrees.\nThis is an approximation.\n");
        while (i < (this.c1 * this.c1)){
            if (i % this.c1 == 0 && i != 0){
                System.out.print("\n");
                h++;
            }
            else if ((i % this.c1) > (this.c1 - h)) System.out.print("   ");
            else System.out.print(" * ");
            i++;
        }
        System.out.println("\n");
    }

    public void dessinerIsocele(){
        int i = 0;
        double b = 0;
        double h = 0;
        int line = 0;
        // Set BASE and Hight
        if (this.c1 != this.c2 && this.c1 != this.c3){
            //c2 = c3
            b = this.c1;
            h = this.c2;
        }
        if (this.c2 != this.c1 && this.c2 != this.c3){
            //c1 = c3
            b = this.c2;
            h = this.c1;
        }
        if (this.c3 != this.c1 && this.c3 != this.c2){
            //c1 = c2
            b = this.c3;
            h = this.c1;
        }
        // Set the Hight to be the lower number
        if (h > b){
            h = h + b;
            b = h - b;
            h = h - b;
        }
        b++; // EOL
        // "Basic" Quick Maths
        if (((b) / 2) != h){
            System.out.println("It is impossible to represent a Regular Isosceles Triangle in ASCII that does not satisfy the condition H = (B + 1) / 2.\n");
            return;
        }
        // DRAWING
        while (i < b * h){
            if (i % b == 0){
                System.out.print("\n");
                line++;
            }
            else if ((i % b) < line || (i % b) > (b - line)) System.out.print("   ");
            else System.out.print(" * ");
            i++;
        }
    }

    public double cosLaw(double a, double b, double c) {
        double cosC = ((a * a + b * b) - (c * c)) / (2 * a * b);
        return Math.toDegrees(Math.acos(cosC));
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

    @Override
    public String obtenirDescription() throws Exception {
        return ("\n------------------------\nIl s'agit d'un Triangle " + this.type + ":\n------------------------\n" + "Cote 1: " + this.c1 + "\nCote 2: " + this.c2 + "\nCote 3: " + this.c3 +
                "\n------------------------\nAngle A: " + this.angles[0] + "\nAngle B: " + this.angles[1] + "\nAngle C: " + this.angles[2] + 
                "\n------------------------\nPerimetre: " + this.calculerPerimetre() + "\nAire: " + this.calculerAire() + "\n------------------------\n");
    }
}
