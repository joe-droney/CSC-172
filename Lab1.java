// Joe Droney

import java.util.ArrayList;
import java.util.List;

public class Lab1<T> {

    public List<T> createListWithoutElements(List<T> originalList, T elementToRemove) {
        List<T> newList = new ArrayList<>();

        for (T element : originalList) {
            if (!element.equals(elementToRemove)) {
                newList.add(element);
            }
        }

        return newList;
    }

    public void prettyPrint(List<T> originalList, T elementToRemove) {
        System.out.println("Original List: " + originalList);
        List<T> newList = createListWithoutElements(originalList, elementToRemove);
        System.out.println("New List without '" + elementToRemove + "': " + newList);
        System.out.println();
    }

    public static void main(String[] args) {
        Lab1<Integer> lab1Integer = new Lab1<>();
        List<Integer> integerList = List.of(1, 2, 3, 2, 4, 5, 2);
        Integer integerElementToRemove = 2;

        lab1Integer.prettyPrint(integerList, integerElementToRemove);

        Lab1<String> lab1String = new Lab1<>();
        List<String> stringList = List.of("apple","orange", "banana", "apple");
        String stringElementToRemove = "apple";
       
        Lab1<Double> lab1Double = new Lab1<>();
        List<Double> doubleList = List.of(1.5, 2.7, 3.0, 2.7, 4.2, 5.1, 2.7);
        Double doubleElementToRemove = 2.7;
        
        lab1Double.prettyPrint(doubleList, doubleElementToRemove);
        
        Lab1<Character> lab1Char = new Lab1<>();
        List<Character> charList = List.of('a', 'b', 'c', 'a', 'd', 'e', 'a');
        Character charElementToRemove = 'a';
        
        lab1Char.prettyPrint(charList, charElementToRemove);
        lab1String.prettyPrint(stringList, stringElementToRemove);
    }
}
