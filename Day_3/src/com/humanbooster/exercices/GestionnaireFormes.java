package com.humanbooster.exercices;

import java.util.ArrayList;

public class GestionnaireFormes{
    // - Manipuler une liste de formes en tant que `Calculable`
    // - Manipuler une liste de formes en tant que `Dessinable`
    // - Démontrer l'utilisation séparée des deux aspects

    private final ArrayList<Dessinable> formeDessinable;
    private final ArrayList<Calculable> formeCalculable;

    public GestionnaireFormes(){
        this.formeDessinable = new ArrayList<>();
        this.formeCalculable = new ArrayList<>();
    }

    // GETTER
    public ArrayList<Dessinable> getFormeDessinable(){
        return this.formeDessinable;
    }
    
    public ArrayList<Calculable> getFormeCalculable(){
        return this.formeCalculable;
    }

    // TESTS
    public void testRectangle() throws Exception{
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 10);
        Rectangle r3 = new Rectangle(10, 20);

        this.formeDessinable.add(r1);
        this.formeDessinable.add(r2);
        this.formeDessinable.add(r3);

        this.formeCalculable.add(r1);
        this.formeCalculable.add(r2);
        this.formeCalculable.add(r3);

        for(Dessinable f : formeDessinable){
            System.out.println(f.obtenirDescription());
            f.dessiner();
            System.out.println("\n");
        }
    }

    public void testTriangle() throws Exception{
        // ISO
        Triangle t0 = new Triangle(8, 8, 15);
        Triangle t1 = new Triangle(10, 10, 15);
        Triangle t2 = new Triangle(10, 15, 10);
        Triangle t3 = new Triangle(15, 10, 10);

        // EQUI
        Triangle t4 = new Triangle(10, 10, 10);

        // RECT
        Triangle t5 = new Triangle(3, 4, 5);
        Triangle t6 = new Triangle(5, 5, 5 * Math.sqrt(2));

        // ABERRANT
        Triangle t7 = new Triangle(1,1,1);
        
        this.formeDessinable.add(t0);        
        this.formeDessinable.add(t1);        
        this.formeDessinable.add(t2);        
        this.formeDessinable.add(t3);        
        this.formeDessinable.add(t4);        
        this.formeDessinable.add(t5);        
        this.formeDessinable.add(t6);        
        this.formeDessinable.add(t7);        

        for(Dessinable f : this.formeDessinable){
            System.out.println(f.obtenirDescription());
            f.dessiner();
            System.out.println("\n");
        }
    }

    public static void testCercle() throws Exception{
        Cercle c1 = new Cercle(5);
        c1.dessiner();
    }
}
