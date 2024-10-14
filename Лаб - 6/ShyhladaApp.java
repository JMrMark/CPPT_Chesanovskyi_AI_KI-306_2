import java.util.*;
import java.io.*;

/**
 * Driver class
 */
public class ShyhladaApp {
    public static void main(String[] args) {
        Shyhlada <? super Data> hdd = new Shyhlada <Data>();
        hdd.AddData(new Box("Nova poshta", 100));
        hdd.AddData(new Book("Alica", 10, 23));
        hdd.AddData(new Charger("White wire", "C-type", 55));
        Data res = hdd.findMax();
        System.out.print("The greatest size of item is: \n");
        res.print();
    }
}

/**
 * Interface 
 */
interface Data extends Comparable<Data> {
    public int getSize();
    public void print();
}

class Shyhlada <T extends Data> {

    private ArrayList<T> arr;

    Shyhlada(){
        arr = new ArrayList<T>();
    }

    public T findMax() {
        if (!arr.isEmpty()) {
            T max = arr.get(0);
            for (int i=1; i< arr.size(); i++) {
                if ( arr.get(i).compareTo(max) > 0 )
                max = arr.get(i);
            }
            return max;
        }
        return null;
    }

    public void AddData(T data) {
        arr.add(data);
        System.out.print("Element added: ");
        data.print();
    }

    public void DeleteData(int i) {
        arr.remove(i);
    }
}

class Box implements Data {

    private String boxname;
    private int size;

    public Box(String pName, int pSize) {
        boxname = pName;
        size = pSize;
    }

    public String getBox() {
        return boxname;
    }

    public void setBox(String name) {
        boxname = name;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(Data p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    public void print() {
        System.out.print("Box: " + boxname + ", Box Size: " + size + ";\n");
    }
}

class Book implements Data {

    private String bookname;
    private int pages;
    private int size;

    public Book(String pName, int ppages, int pSize) {
        bookname = pName;
        pages = ppages;
        size = pSize;
    }

    public String getBook() {
        return bookname;
    }

    public void setBook(String name) {
        bookname = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int name) {
        pages = name;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(Data p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    public void print() {
        System.out.print("Book: " + bookname + ", Pages: " + pages + ", Book Size: " + size + ";\n");
    }
}

class Charger implements Data {

    private String chargername;
    private String Type;
    private int size;

    public Charger(String pName, String pType, int pSize) {
        chargername = pName;
        Type = pType;
        size = pSize;
    }

    public String getCharger() {
        return chargername;
    }

    public void setCharger(String name) {
        chargername = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String name) {
        Type = name;
    }

    public int getSize() {
        return size;
    }

    public int compareTo(Data p) {
        Integer s = size;
        return s.compareTo(p.getSize());
    }

    public void print() {
        System.out.print("Charger: " + chargername + ", Type: " + Type + ", Charger Size: " + size + ";\n");
    }
}