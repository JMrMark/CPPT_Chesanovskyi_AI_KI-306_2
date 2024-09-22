package KI306_Chesanovskyi_Lab3;

import java.io.FileNotFoundException;

public class PatronApp{
    public static void main(String[] args) throws FileNotFoundException{
        SmartPatron smptr = new SmartPatron(0.9, 10, false);

        System.out.print("Patron's distance: " + smptr._DistanceFlight() + "m.\n");

        System.out.print("Patron's hit probability: " + smptr._HitProbability('n') + "%\n");

        smptr.ShowWorkOfSuperClas();

        smptr.EndOperatinSmartPatron();
    }
}