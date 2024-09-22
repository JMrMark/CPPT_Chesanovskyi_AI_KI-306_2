package KI306_Chesanovskyi_Lab3;

import java.io.*;

import KI306_Chesanovskyi_Lab3.Patron;

/**
 * Interface to calculate the flight distance of the cartridge
 */
interface Flight {

    double _DistanceFlight();

}
/**
 * Interface to calculate the probability of the hit
 * @FatHuman
 * @Human 
 * @ThinHuman 
 */
interface HitProbability {

    double FatHuman = 1.5;
    double Human = 1;
    double ThinHuman = 0.5;
    
    double _HitProbability(char tl);

}

/**
 * Class to make Patron more smart. It has:
 * - PointingAccuracy;
 * - Power;
 * - AutoAim;
 */
public class SmartPatron extends Patron implements Flight, HitProbability{

    private double PointingAccuracy;
    private double Power;
    private boolean AutoAim;
    private PrintWriter fout;


    /**
     * Constructor
     * @param PA
     * @param P
     * @param AA
     * @throws FileNotFoundException
     */
    public SmartPatron(double PA, double P, boolean AA) throws FileNotFoundException{
        super(10, 'f', false, false);
        PointingAccuracy = PA;
        Power = P;
        AutoAim = AA;
        fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public SmartPatron() throws FileNotFoundException{
        super(10, 'f', false, false);
        PointingAccuracy = 0.1;
        Power = 1;
        AutoAim = false;
        fout = new PrintWriter(new File("Log.txt"));
    }


    /**
     * Func from interface to calculate distance;
     */
    public double _DistanceFlight(){
        fout.print("|=========================================\n");
        fout.print("| The SmartPatron's distance dlight is " + Power * 43.2 +"m\n");
        fout.print("|=========================================\n");
        fout.flush();
        return Power * 43.2;
    }


    /**
     * Func from interface to calculate hit probability
     */
    public double _HitProbability(char tl){
        double res = (PointingAccuracy * Power)/(Power * 43.2 * Power * 43.2);
        if (AutoAim == true){
            res = 0.99;
        }
        else if (tl == 'f'){
            res = (res * FatHuman) * 1000000;
        }
        else if (tl == 't'){
            res = (res * ThinHuman) * 1000000;
        }
        else {
            res = (res * Human) * 1000000;
        }
        fout.print("|=========================================\n");
        fout.print("| The SmartPatron's hit probability is " + res +"%\n");
        fout.print("|=========================================\n");
        fout.flush();
        return res;
    }   
    

    /**
     * Some func from super class
     */
    public void ShowWorkOfSuperClas(){
        // Виведення інформації про патрон
        super.ShowInfoOfPatron(fout);  

        // Постріл
        super.ShootPatron(fout);

        // Постріл
        super.ShootPatron(fout);

        // Перезарядка
        super.ReloadPatron(fout);

        // Внесення патрону під заборону
        super.BanPatron(fout);

        // Постріл
        super.ShootPatron(fout);

        // Заміна калібру кулі
        super.ChangeCaliberPatron(5.56, fout);

        // Винесення патрону з-під заборони
        super.UnBanPatron(fout);

        // Кінець операцій над патроном
        //super.EndOperationsPatron(fout);
    }

    /**
     * close fout
     */
    public void EndOperatinSmartPatron(){
        fout.close();
        System.out.print("SmartPatron is over ( Died or something =] ) \n");
        fout.print("|=========================================\n");
        fout.print("| The smart patron was successfully used and now it is gone. Bye ;] \n");
        fout.print("|=========================================\n");
    }
}
