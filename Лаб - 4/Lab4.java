import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
/**
* Class <code>EquationsApp</code> Implements driver for Equations class
* @author Artem
* @version 1.0
*/
public class Lab4 {
/**
* @param args
*/
public static void main(String[] args) {
    try {
        out.print("Enter file name: ");
        Scanner in = new Scanner(System.in);
        String fName = in.nextLine();
        PrintWriter fout = new PrintWriter(new File(fName));
        try {
            try {
                Equations eq = new Equations();
                out.print("Enter X: ");
                fout.print(eq.calculate(in.nextInt()));
            }
            finally {
                // Цей блок виконається за будь-яких обставин
                fout.flush();
                fout.close();
                in.close();
        }
        }
        catch (CalcException ex) {
            // Блок перехоплює помилки обчислень виразу
            out.print(ex.getMessage());
        }
    }
        catch (FileNotFoundException ex) {
            // Блок перехоплює помилки роботи з файлом навіть якщо вони
            // виникли у блоці finally
            out.print("Exception reason: Perhaps wrong file path");
        }
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

/**
* Class <code>Equations</code> implements method for ((2 / tg(x)) / x) expression
* calculation
* @author EOM Stuff
* @version 1.0
*/
class Equations {
/**
* Method calculates the (1 / tg(2x)) expression
* @param <code>x</code> Angle in degrees
* @throws CalcException
*/
public double calculate(int x) throws CalcException {
    double y, rad;
    rad = x * Math.PI / 180.0;
    try {
        y = 1 / Math.tan(2*rad);
        // Якщо результат не є числом, то генеруємо виключення
        if (y==Double.NaN || y==Double.NEGATIVE_INFINITY || 
        y==Double.POSITIVE_INFINITY || x==90 || x== -90)
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
return y;
}
}
