import java.io.*;
import java.util.*;

/**
 * Клас Lab1 реалізує приклад програми до лабораторної роботи №1
 */
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
 
        // Верхня частина (зростаючі ряди)
        for (int i = 1; i <= nRows / 2; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(filler);
                fout.print(filler);
            }
            System.out.println(); // Перехід на новий рядок
            fout.println(); // Запис у файл
        }

        //Середина
        int mark; // Змінна для перевірки на парність чи непарність числа nRows (розміру масиву)
        if (nRows % 2 == 0) mark = 0;
        else mark = 1;

        for (int i = 0; i < (nRows / 2) + mark; i++){
            System.out.print(filler);
            fout.print(filler);
        }
        System.out.println(); // Перехід на новий рядок
        fout.println(); // Запис у файл

        // Нижня частина (спадні ряди)
        for (int i = (nRows - 1) / 2; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(filler);
                fout.print(filler);
            }
            System.out.println(); // Перехід на новий рядок
            fout.println(); // Запис у файл
        }

        // Закриття файлів
        in.close();
        fout.flush();
        fout.close(); 
    }
}