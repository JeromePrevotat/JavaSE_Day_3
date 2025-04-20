package com.humanbooster.exercices;

public class GestionnaireFormes {
    // - Manipuler une liste de formes en tant que `Calculable`
    // - Manipuler une liste de formes en tant que `Dessinable`
    // - Démontrer l'utilisation séparée des deux aspects

    public static void testRectangle() throws Exception{
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 10);
        Rectangle r3 = new Rectangle(10, 20);
        System.out.println("\n");
        r1.dessiner();
        System.out.println("\n\n" + r1.obtenirDescription());
        
        System.out.println("\n");
        r2.dessiner();
        System.out.println("\n\n" + r2.obtenirDescription());
        
        System.out.println("\n");
        r3.dessiner();
        System.out.println("\n\n" + r3.obtenirDescription());
    }

    public static void testTriangle() throws Exception{
        Triangle t1 = new Triangle(10, 10, 15);
        Triangle t2 = new Triangle(10, 15, 10);
        Triangle t3 = new Triangle(15, 10, 10);
        Triangle t4 = new Triangle(10, 10, 10);
        Triangle t5 = new Triangle(3, 4, 5);
        Triangle t6 = new Triangle(5, 5, 5 * Math.sqrt(2));
        
        System.out.println("\n");
        // t1.dessiner();
        // System.out.println("\n\n" + t1.obtenirDescription());

        System.out.println("\n\n" + t1.obtenirDescription());
        System.out.println("\n\n" + t2.obtenirDescription());
        System.out.println("\n\n" + t3.obtenirDescription());
        System.out.println("\n\n" + t4.obtenirDescription());
        System.out.println("\n\n" + t5.obtenirDescription());
        System.out.println("\n\n" + t6.obtenirDescription());

    }
}
