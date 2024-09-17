import java.io.*;
import java.util.*;
/*
 * Клас для створення зубчастого масиву та його заповнення відповідним візерунком
 */
public class Lab1ChesanovskyiKI306 {
    /*
     * Головний метод програми
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        File dataFile = new File("Result.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Читаємо розмір масиву і символ заповнення
        int nRows = readSize(in);
        char filler = readFiller(in);

        // Створюємо зубчастий масив
        char[][] jaggedArray = createJaggedArray(nRows);

        // Заповнюємо масив символом
        fillJaggedArray(jaggedArray, filler);

        // Виводимо масив на екран і у файл
        printJaggedArray(jaggedArray, fout);

        // Закриття файлів
        in.close();
        fout.flush();
        fout.close();
    }

    /*
     * Метод для зчитування розміру масиву від користувача
     */
    public static int readSize(Scanner in) {
        System.out.print("Size: ");
        return in.nextInt();
    }

    /*
     * Метод для зчитування символу від користувача
     */
    public static char readFiller(Scanner in) {
        in.nextLine(); // очищаємо буфер
        System.out.print("Symbol: ");
        String fillerInput = in.nextLine();
        
        // Перевірка символу на символьність
        if (fillerInput.length() != 1) {
            System.out.println("Please provide exactly one symbol.");
            System.exit(1); // завершення програми, якщо введено більше одного символу
        }

        return fillerInput.charAt(0); // Повертаємо перший символ введеного рядка
    }

    /*
     * Метод для створення зубчастого масиву
     */
    public static char[][] createJaggedArray(int nRows) {
        char[][] jaggedArray = new char[nRows][];

        for (int i = 0; i < nRows; i++) {
            int midPoint = nRows / 2;
            int numSymbols = (i < midPoint) ? i + 1 : nRows - i; // кількість символів в рядку
            jaggedArray[i] = new char[numSymbols]; // виділяємо пам'ять під символи
        }

        return jaggedArray;
    }

    /*
     * Метод для заповнення зубчастого масиву
     */
    public static void fillJaggedArray(char[][] jaggedArray, char filler) {
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = filler;
            }
        }
    }

    /*
     * Метод для виведення масиву на екран і у файл
     */
    public static void printJaggedArray(char[][] jaggedArray, PrintWriter fout) {
        for (char[] row : jaggedArray) {
            for (char symbol : row) {
                System.out.print(symbol);
                fout.print(symbol);
            }
            System.out.println(); // перехід на новий рядок
            fout.print("\n");
        }
    }
}