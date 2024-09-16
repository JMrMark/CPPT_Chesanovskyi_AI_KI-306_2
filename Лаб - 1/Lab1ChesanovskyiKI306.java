import java.io.*;
import java.util.*;

public class Lab1ChesanovskyiKI306 {
    public static void main(String[] args) throws FileNotFoundException {
        // Створення та ініціалізація змінних
        int nRows;
        char filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("Result.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Ввід розміру масива
        System.out.print("Size: ");
        nRows = in.nextInt();
        in.nextLine(); // Щоб позбутися символу переходу на новий рядок після введення числа

        // Ввід символу розфарбовки
        System.out.print("Symbol: ");
        String fillerInput = in.nextLine();
        
        // Перевірка символу на символьність =)
        if (fillerInput.length() != 1) {
            System.out.println("Please provide exactly one symbol.");
            in.close();
            fout.flush();
            fout.close();
            return;
        }
        
        filler = fillerInput.charAt(0); // Беремо перший символ зі введеного рядка

        // Створюємо зубчастий масив
        char[][] jaggedArray = new char[nRows][];

        // Виділяємо пам'ять для кожного рядка
        for (int i = 0; i < nRows; i++) {
            int midPoint = nRows / 2;
            int numSymbols = (i < midPoint) ? i + 1 : nRows - i; // кількість символів в рядку
            jaggedArray[i] = new char[numSymbols]; // виділяємо пам'ять під символи
        }

        // Заповнюємо масив символом '#'
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = filler;
            }
        }

        // Виводимо масив
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j]);
                fout.print(jaggedArray[i][j]);
            }
            System.out.println(); // перехід на новий рядок
            fout.print("\n");
        }

        // Закриття файлів
        in.close();
        fout.flush();
        fout.close(); 
    }
}
