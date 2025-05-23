import com.humanbooster.exercices.GestionnaireFormes;
import com.humanbooster.exercices.Moto;
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
        GestionnaireFormes formes = new GestionnaireFormes();
        formes.testRectangle();
        formes.testTriangle();
        System.out.println("Collection Size : " + formes.getFormeDessinable().size());
        //GestionnaireFormes.testTriangle();
        //GestionnaireFormes.testCercle();
    }
}
