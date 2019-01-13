package generics_and_wildcards;


import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics_AND_Wildcards3 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        printAll(integerList);
        printAllTypeParameter(integerList);
        List<Double> doubleList = Arrays.asList(1.2, 2.3, 3.5);
        printAll(doubleList);
        printAllTypeParameter(doubleList);
//        List<?> list = new ArrayList<>();             //can not be used like this
//        list.add(new Integer(6));
    }

    public static <T> void printAllTypeParameter(List<T> list) {
        for (T item : list)
            System.out.println(item + " ");
    }
    //both are correct!
    public static void printAll(List<?> list) {
        for (Object item : list)
            System.out.println(item + " ");
    }
}
