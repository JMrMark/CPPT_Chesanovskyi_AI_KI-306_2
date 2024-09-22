package KI306_Chesanovskyi_Lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * The class that describes the cartridge
 * Includes the following characteristics:
 * - Caliber
 * - Type
 * - Condition (use)
 * - Prohibition
 */
public abstract class Patron {

    private Caliber _Caliber;
    private Type _Type;
    private Usage _Usage;
    private PGC _PGC;
    //private PrintWriter fout;

    /**
     * Constructor
     * @throws FileNotFoundException
     */
    public Patron() throws FileNotFoundException { 
        _Caliber = new Caliber();
        _Type = new Type();
        _Usage = new Usage();
        _PGC = new PGC();
        //fout = new PrintWriter(new File("Log.txt"));
    }
    /**
     * Constructor
     * @param <code>All_data</code> All data included
     * @throws FileNotFoundException
     */
    public Patron(double cal, char tp, boolean useG, boolean ps) throws FileNotFoundException { 
        _Caliber = new Caliber(cal);
        _Type = new Type(tp);
        _Usage = new Usage(useG);
        _PGC = new PGC(ps);
        //fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Method to show all info about Patron
     */
    public void ShowInfoOfPatron(PrintWriter fout){
        System.out.print("Caliber of the Patron is " + CaliberCheckPatron() + " mm\n");
        System.out.print("The type of Patron is " + TypeCheckPatron() + "\n");
        System.err.print("Patron is " + UsageCheckPatron() + "\n");
        System.out.print("The patron is " + PGCCheckPatron() + " the prohibition of the Geneva Convention\n");
        
        fout.print("|=========================================\n");
        fout.print("| **Information about the Patron was shown**\n");
        fout.print("| Caliber of the Patron is " + CaliberCheckPatron() + " mm\n");
        fout.print("| The type of Patron is " + TypeCheckPatron() + "\n");
        fout.print("| Patron is " + UsageCheckPatron() + "\n");
        fout.print("| The patron is " + PGCCheckPatron() + " the prohibition of the Geneva Convention\n");
        fout.print("|=========================================\n");
        fout.flush();
    }

    /**
     * Method to use the Patron
     */
    public void ShootPatron(PrintWriter fout){
        if (_PGC.GetPGC()){
            System.out.print("The patron is UNDER the prohibition of the Geneva Convention\n");
            fout.print("|=========================================\n");
            fout.print("| The user tried to use forbidden Patron \n");
            fout.print("| This action was rejected \n");
            fout.print("|=========================================\n");
            fout.flush();
            return;
        }
        if (_Usage.GetUsage()){
            System.out.print("The patron is already used! \n");
            fout.print("|=========================================\n");
            fout.print("| The user tried to use used Patron \n");
            fout.print("| This action was rejected \n");
            fout.print("|=========================================\n");
            fout.flush();
        }
        else{
            _Usage.SetUsage(true);
            System.out.print("The patron was used! \n");
            fout.print("|=========================================\n");
            fout.print("| The patron was used! \n");
            fout.print("|=========================================\n");
            fout.flush();
        }
    }

    /**
     * Method to reload the Patron
     */
    public void ReloadPatron(PrintWriter fout){
        if (!_Usage.GetUsage()){
            System.out.print("The patron is already avalible to shoot! \n");
            fout.print("|=========================================\n");
            fout.print("| The user tried to reload avalible to shoot Patron \n");
            fout.print("| This action was rejected \n");
            fout.print("|=========================================\n");
            fout.flush();
        }
        else{
            _Usage.SetUsage(false);
            System.out.print("The patron is reload, now you can use it! \n");
            fout.print("|=========================================\n");
            fout.print("| The patron was successfully reload! \n");
            fout.print("|=========================================\n");
            fout.flush();
        }
    }

    /**
     * Ban on the use of the cartridge
     */
    public void BanPatron(PrintWriter fout){
        _PGC.SetPGC(true);
        System.out.print("The patron has been banned \n");
        fout.print("|=========================================\n");
        fout.print("| The patron was successfully banned! \n");
        fout.print("|=========================================\n");
        fout.flush();
    }

    /**
     * Issuance of a permit to use the cartridge
     */
    public void UnBanPatron(PrintWriter fout){
        _PGC.SetPGC(false);
        System.out.print("The patron has been unbanned \n");
        fout.print("|=========================================\n");
        fout.print("| The patron was successfully unbanned! \n");
        fout.print("|=========================================\n");
        fout.flush();
    }

    /**
     * Caliber replacement
     * @param cal
     */
    public void ChangeCaliberPatron(double cal, PrintWriter fout){
        System.out.print("Caliber of the patron has been changed \n");
        fout.print("|=========================================\n");
        fout.print("| User has changed the caliber of the patron \n");
        fout.print("| From " + _Caliber.GetCaliber() + " to " + cal + "\n");
        fout.print("|=========================================\n");
        fout.flush();

        _Caliber.SetCaliber(cal);

    }

    /**
     * Close file read change
     */
    public void EndOperationsPatron(PrintWriter fout){
        System.out.print("Patron is over ( Died or something =] ) \n");
        fout.print("|=========================================\n");
        fout.print("| The patron was successfully used and now it is gone. Bye ;] \n");
        fout.print("|=========================================\n");
        fout.close();
    }

    private double CaliberCheckPatron(){
        return _Caliber.GetCaliber();
    }

    private String PGCCheckPatron(){
        if (_PGC.GetPGC()){
            return "UNDER";
        }
        return "NOT UNDER";
    }

    private String UsageCheckPatron(){
        if (_Usage.GetUsage()){
            return "USED";
        }
        return "NOT USED";
    }

    private String TypeCheckPatron(){
        char ch = _Type.GetType();
        if (ch == 'n'){
            return "Not specified";
        }
        if (ch == 'a'){
            return "Armor piercing";
        }
        if (ch == 's'){
            return "Simple";
        }
        if (ch == 'f'){
            return "Incendiary (fire)";
        }
        return "Error";
    }
}


class Caliber {
    
    private double __Caliber;

    /**
     * Constructur for caliber (makes caliber size in mm)
     * @param cal
     */
    public Caliber(double cal){
        __Caliber = cal;
    }

    /**
     * Constructur for caliber (makes caliber size in mm)
     */
    public Caliber(){
        __Caliber = 0;
    }

    /**
     * Set __Caliber of the Patron
     * @param Cal
     */
    public void SetCaliber(double Cal){
        __Caliber = Cal;
    }

    public double GetCaliber(){
        return __Caliber;
    }
}

/**
 * 'n' = none
 * 'a' = armor piercing
 * 's' = simple
 * 'f' = incendiary (fire) 
 */
class Type {

    private char __Type;

    /**
     * Constructor for type of the patron
     * @param typ
     */
    public Type(char typ){
        __Type = typ;
    }

    /**
     * Constructor for type of the patron
     */
    public Type(){
        __Type = 'n';
    }
    
    /**
     * Get __Type of the Patron
     * @return
     */
    public char GetType(){
        return __Type;
    }

    /**
     * Set __Type of the Patron
     * @param tp
     */
    public void SetType(char tp){
        __Type = tp;
    }
}

/**
 * Used = true
 * Not Used = false
 */
class Usage {
    private boolean __Usage;

    /**
     * Constructor for usage of the patron
     * @param usa
     */
    public Usage(boolean usa){
        __Usage = usa;
    }

    /**
     * Constructor for usage of the patron
     */
    public Usage(){
        __Usage = false;
    }

    public boolean GetUsage(){
        return __Usage;
    }

    /**
     * Set usage of the Patron
     * @param us
     */
    public void SetUsage(boolean us){
        __Usage = us;
    }
}

/**
 * Permission of the Geneva Convention
 * Forbidden = 'true'
 * Not forbidden = 'false'
 */
class PGC{
    private boolean __PGC;

    /**
     * Permission of the Geneva Convention
     * @param ps
     */
    public PGC(boolean ps){
        __PGC = ps;
    }

    /**
     * Permission of the Geneva Convention
     */
    public PGC(){
        __PGC = false;
    }

    public boolean GetPGC(){
        return __PGC;
    }

    /**
     * Set PGC of the Patron
     * @param ps
     */
    public void SetPGC(boolean ps){
        __PGC = ps;
    }
}