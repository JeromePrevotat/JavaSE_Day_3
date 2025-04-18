import com.humanbooster.exercices.Moto;
import com.humanbooster.exercices.Rectangle;
import com.humanbooster.exercices.Voiture;

public class App {
    public static void main(String[] args) throws Exception {
        //ex1();
        ex2();
    }

    public static void ex1() throws Exception{
        Voiture clio = new Voiture("Renault", "Clio", 170, 3, 4, 0);
        Moto trucQuiFaitDuBruit = new Moto("Ducati", "Vroum Vroum", 280, 1, 2);

        clio.demarrer();
        while (clio.getActualSpeed() < clio.getVitesseMax())
            clio.accelerer();
        while (clio.getActualSpeed() > 0)
            clio.freiner();
    }

    public static void ex2() throws Exception{
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
        r2.dessiner();
        System.out.println("\n\n" + r2.obtenirDescription());
    }
}
