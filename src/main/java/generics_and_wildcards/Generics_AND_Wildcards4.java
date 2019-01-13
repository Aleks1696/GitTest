package generics_and_wildcards;

import java.util.ArrayList;
import java.util.List;

public class Generics_AND_Wildcards4 {
    public static void main(String[] args) {

        List<? extends Integer> list = new ArrayList<>();
        List<Integer> intlist = new ArrayList<>();


        list = intlist;


    }
}
