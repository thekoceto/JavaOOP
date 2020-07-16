package P07_CollectionHierarchy;

import P07_CollectionHierarchy.functionality.AddCollection;
import P07_CollectionHierarchy.functionality.AddRemoveCollection;
import P07_CollectionHierarchy.functionality.MyListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] elements = reader.readLine().split(" ");

        for (String element : elements) {
            System.out.print(addCollection.add(element) + " ");
        }
        System.out.println();

        for (String element : elements) {
            System.out.print(addRemoveCollection.add(element) + " ");
        }
        System.out.println();

        for (String element : elements) {
            System.out.print(myList.add(element) + " ");
        }
        System.out.println();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(myList.remove() + " ");
        }
    }
}