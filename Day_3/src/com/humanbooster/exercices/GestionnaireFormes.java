package com.humanbooster.exercices;

import java.util.ArrayList;

public class GestionnaireFormes{
    // - Manipuler une liste de formes en tant que `Calculable`
    // - Manipuler une liste de formes en tant que `Dessinable`
    // - Démontrer l'utilisation séparée des deux aspects

    private static ArrayList<Dessinable> formeDessinable;
    private static ArrayList<Calculable> formeCalculable;

    public GestionnaireFormes(){
        formeDessinable = new ArrayList<>();
        formeCalculable = new ArrayList<>();
    }

    // GETTER
    public ArrayList<Dessinable> getFormeDessinable(){
        return formeDessinable;
    }
    
    public ArrayList<Calculable> getFormeCalculable(){
        return formeCalculable;
    }

    public static void testRectangle() throws Exception{
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 10);
        Rectangle r3 = new Rectangle(10, 20);

        formeDessinable.add(r1);
        formeDessinable.add(r2);
        formeDessinable.add(r3);

        formeCalculable.add(r1);
        formeCalculable.add(r2);
        formeCalculable.add(r3);

        for(Dessinable f : formeDessinable){
            if (f instanceof Rectangle){
                System.out.println(f.obtenirDescription());
                f.dessiner();
                System.out.println("\n");
            }
        }
    }

    public static void testTriangle() throws Exception{
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
        
        formeDessinable.add(t0);        
        formeDessinable.add(t1);        
        formeDessinable.add(t2);        
        formeDessinable.add(t3);        
        formeDessinable.add(t4);        
        formeDessinable.add(t5);        
        formeDessinable.add(t6);        
        formeDessinable.add(t7);        

        for(Dessinable f : formeDessinable){
            if (f instanceof Triangle){
                System.out.println(f.obtenirDescription());
                f.dessiner();
                System.out.println("\n");
            }
        }
    }

    public static void testCercle() throws Exception{
        Cercle c1 = new Cercle(5);
        c1.dessiner();
    }
}
