import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Lab5 {
/**
* @param args
*/
public static void main(String[] args) throws FileNotFoundException, IOException {
    // TODO Auto-generated method stub
    CalcWFio obj = new CalcWFio();
    Scanner s = new Scanner(System.in);
    System.out.print("Enter data: ");
    double data = s.nextDouble();
    try {
        obj.calculate(data);
    }
    catch(CalcException ex) {
        out.print(ex.getMessage());
        return;
    }
    System.out.println("Result is: " + obj.getResult());
    obj.writeResTxt("textRes.txt");
    obj.writeResBin("BinRes.bin");
    obj.readResBin("BinRes.bin");
    System.out.println("Result is: " + obj.getResult());
    obj.readResTxt("textRes.txt");
    System.out.println("Result is: " + obj.getResult());
}
}


/*
 * Class or calculations and file operate
 */
class CalcWFio extends ArithmeticException {

    private double result;

/*
 * Write data to txt file
 */
public void writeResTxt(String fName) throws FileNotFoundException {
    PrintWriter f = new PrintWriter(fName);
    f.printf("%f ",result);
    f.close();
}

/*
 * Read data from txt file
 */
public void readResTxt(String fName) {
    try {
        File f = new File (fName);
        if (f.exists()) {
            Scanner s = new Scanner(f);
            result = s.nextDouble();
            s.close();
        }
        else
        throw new FileNotFoundException("File " + fName + "not found");
        }
    catch (FileNotFoundException ex) {
        System.out.print(ex.getMessage());
    }
}

/**
 * Write data to bin file
 * @param fName
 * @throws FileNotFoundException
 * @throws IOException
 */
public void writeResBin(String fName) throws FileNotFoundException, IOException {
    DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
    f.writeDouble(result);
    f.close();
}

/**
 * Read data from bin file
 * @param fName
 * @throws FileNotFoundException
 * @throws IOException
 */
public void readResBin(String fName) throws FileNotFoundException, IOException {
    DataInputStream f = new DataInputStream(new FileInputStream(fName));
    result = f.readDouble();
    f.close();
}


/**
 * Calculate the result
 * @param x
 * @throws CalcException
 */
public void calculate(double x) throws CalcException {
    double rad = x * Math.PI / 180.0;
    double res;
    try {
        res = 1 / Math.tan(2*rad);
        // Якщо результат не є числом, то генеруємо виключення
        if (res==Double.NaN || res==Double.NEGATIVE_INFINITY || 
        res==Double.POSITIVE_INFINITY || x % 45 == 0)
        throw new ArithmeticException();
    }
    catch (ArithmeticException ex) {
    // створимо виключення вищого рівня з поясненням причини
    // виникнення помилки
    if (x % 45 == 0)
    throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
    else
    throw new CalcException("Unknown reason of the exception during exception calculation");
    }
    result = res;
}

/*
 * Get the result
 */
public double getResult() {
    return result;
}
}

/**
* Class <code>CalcException</code> more precises ArithmeticException
* @author EOM Stuff
* @version 1.0
*/
class CalcException extends ArithmeticException {

    public CalcException(){}
    
    public CalcException(String cause) {
        super(cause);
    }
}
